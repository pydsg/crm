package com.huike.business.service.impl;


import com.huike.business.domain.TbBusinessTrackRecord;
import com.huike.business.domain.vo.BusinessTrackVo;
import com.huike.business.mapper.TbBusinessTrackRecordMapper;
import com.huike.business.service.ITbBusinessTrackRecordService;
import com.huike.common.utils.SecurityUtils;
import com.huike.common.utils.StringUtils;
import com.huike.common.utils.bean.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 商机跟进记录Service业务层处理
 * 
 * @author wgl
 * @date 2021-04-28
 */
@Service
public class TbBusinessTrackRecordServiceImpl implements ITbBusinessTrackRecordService {

    @Autowired
    private TbBusinessTrackRecordMapper tbBusinessTrackRecordMapper;

    /**
     * 新增商机跟进记录
     */
    @Override
    public void addBusinessTrackRecord(BusinessTrackVo businessTrackVo) {

        // 由于查询需要用到用户名 调用工具类获取用户名
        String nowUsername = SecurityUtils.getUsername();

        //判断用户数据是否为空
        if(StringUtils.isBlank(nowUsername)){
            throw new RuntimeException("当前操作用户数据为空");
        }

        tbBusinessTrackRecordMapper.updateBusiness(businessTrackVo);

        //封装：拷贝数据
        TbBusinessTrackRecord tbBusinessTrackRecord = new TbBusinessTrackRecord();
        tbBusinessTrackRecord.setBusinessId(businessTrackVo.getBusinessId());
        tbBusinessTrackRecord.setTrackStatus(businessTrackVo.getTrackStatus());
        tbBusinessTrackRecord.setNextTime(businessTrackVo.getNextTime());
        tbBusinessTrackRecord.setKeyItems(businessTrackVo.getKeyItems());
        tbBusinessTrackRecord.setRecord(businessTrackVo.getRecord());
        tbBusinessTrackRecord.setCreateBy(nowUsername);
        tbBusinessTrackRecord.setCreateTime(new Date());

        //添加进表
        tbBusinessTrackRecordMapper.addBusinessTrackRecord(tbBusinessTrackRecord);

    }

    /**
     * 查询商机跟进记录列表
     */
    @Override
    public List<TbBusinessTrackRecord> getBusinessTrackRecordByList(Long id) {
        return tbBusinessTrackRecordMapper.getBusinessTrackRecordByList(id);
    }
}
