package com.huike.clues.mapper;


import com.huike.clues.domain.TbClue;
import com.huike.clues.domain.TbClueTrackRecord;
import com.huike.clues.domain.vo.ClueTrackRecordVo;
import com.huike.common.core.page.TableDataInfo;

import java.util.List;

/**
 * 线索跟进记录Mapper接口
 * @date 2021-04-19
 */
public interface TbClueTrackRecordMapper {


    void addClueTrackRecord(TbClueTrackRecord tbClueTrackRecordTemp);

    List<TbClueTrackRecord> selectByClueId(Long clueId);

    void updateClue(TbClue tbClue);
}
