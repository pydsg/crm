package com.huike.task.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

public interface RecoveryMapper {
    //线索回收：线索失效时间 <= 当前时间，线索可能已经无效，系统自动回收到线索池
    @Update("update tb_clue set next_time=null, status=#{status} where end_time <= #{now} and status IN (1,2,4)")
    void resetNextTimeAndStatusOnClue(@Param("status")String status, @Param("now") Date date);

    //商机回收：商机失效时间 <= 当前时间，商机可能已经无效，系统自动回收到公海池
    @Update("update tb_business set next_time=null, status=#{status} where end_time <= #{now} and status IN (1,2,4)")
    void resetNextTimeAndStatusOnBusiness(@Param("status")String tbBusiness_recovery,@Param("now") Date date);

}
