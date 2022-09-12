package com.huike.business.service;

import com.huike.business.domain.TbBusinessTrackRecord;
import com.huike.business.domain.vo.BusinessTrackVo;

import java.util.List;

/**
 * 商机跟进记录Service接口
 * @date 2021-04-28
 */
public interface ITbBusinessTrackRecordService {


    void addBusinessTrackRecord(BusinessTrackVo businessTrackVo);

    List<TbBusinessTrackRecord> getBusinessTrackRecordByList(Long id);
}
