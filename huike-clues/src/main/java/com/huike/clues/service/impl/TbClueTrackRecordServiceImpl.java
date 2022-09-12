package com.huike.clues.service.impl;


import com.huike.clues.domain.TbClue;
import com.huike.clues.domain.TbClueTrackRecord;
import com.huike.clues.domain.vo.ClueInfoVO;
import com.huike.clues.domain.vo.ClueTrackRecordVo;
import com.huike.clues.mapper.TbClueTrackRecordMapper;
import com.huike.clues.service.ITbClueTrackRecordService;
import com.huike.common.core.page.TableDataInfo;
import com.huike.common.utils.SecurityUtils;
import com.huike.common.utils.StringUtils;
import com.huike.common.utils.bean.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 线索跟进记录Service业务层处理
 * @date 2022-04-22
 */
@Service
public class TbClueTrackRecordServiceImpl implements ITbClueTrackRecordService {

    @Autowired
    private TbClueTrackRecordMapper tbClueTrackRecordMapper;

    /**
     * 新增线索跟进记录
     */
    @Override
    public void addClueTrackRecord(ClueTrackRecordVo tbClueTrackRecord) {

        // 由于查询需要用到用户名 调用工具类获取用户名
        String nowUsername = SecurityUtils.getUsername();

        //判断用户数据是否为空
        if(StringUtils.isBlank(nowUsername)){
            throw new RuntimeException("当前操作用户数据为空");
        }

        //更新线索信息
        TbClue tbClue = new TbClue();
        tbClue.setId(tbClueTrackRecord.getClueId());
        tbClue.setSubject(tbClueTrackRecord.getSubject());
        tbClue.setLevel(tbClueTrackRecord.getLevel());
        tbClue.setName(tbClueTrackRecord.getName());
        tbClue.setSex(tbClueTrackRecord.getSex());
        tbClue.setWeixin(tbClueTrackRecord.getWeixin());
        tbClue.setQq(tbClueTrackRecord.getQq());
        tbClue.setAge(tbClueTrackRecord.getAge());
        tbClue.setNextTime(tbClueTrackRecord.getNextTime());
        tbClueTrackRecordMapper.updateClue(tbClue);

        //封装数据
        TbClueTrackRecord tbClueTrackRecordTemp = new TbClueTrackRecord();
        tbClueTrackRecordTemp.setClueId(tbClueTrackRecord.getClueId());
        tbClueTrackRecordTemp.setLevel(tbClueTrackRecord.getLevel());
        tbClueTrackRecordTemp.setSubject(tbClueTrackRecord.getSubject());
        tbClueTrackRecordTemp.setRecord(tbClueTrackRecord.getRecord());
        tbClueTrackRecordTemp.setNextTime(tbClueTrackRecord.getNextTime());
        tbClueTrackRecordTemp.setNextTime(tbClueTrackRecord.getNextTime());
        tbClueTrackRecordTemp.setCreateBy(nowUsername);
        tbClueTrackRecordTemp.setCreateTime(new Date());
        //添加
        tbClueTrackRecordMapper.addClueTrackRecord(tbClueTrackRecordTemp);

    }

    /**
     * 查询线索跟进记录列表
     */
    @Override
    public TableDataInfo selectByClueId(Long clueId) {
        //根据线索id查询
        List<TbClueTrackRecord> tbClueTrackRecord = tbClueTrackRecordMapper.selectByClueId(clueId);
        //封装
        TableDataInfo tableDataInfo = new TableDataInfo(tbClueTrackRecord, tbClueTrackRecord.size());
        tableDataInfo.setCode(200);
        tableDataInfo.setMsg("查询成功");
        return tableDataInfo;
    }
}
