package com.huike.business.mapper;

import java.util.List;
import com.huike.business.domain.TbBusinessTrackRecord;
import com.huike.business.domain.vo.BusinessTrackVo;

/**
 * 商机跟进记录Mapper接口
 * @date 2021-04-28
 */
public interface TbBusinessTrackRecordMapper {

    void addBusinessTrackRecord(TbBusinessTrackRecord tbBusinessTrackRecord);

    List<TbBusinessTrackRecord> getBusinessTrackRecordByList(Long id);

    void updateBusiness(BusinessTrackVo businessTrackVo);
}