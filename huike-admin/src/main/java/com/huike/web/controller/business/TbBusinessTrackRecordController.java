package com.huike.web.controller.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huike.business.domain.TbBusiness;
import com.huike.business.domain.TbBusinessTrackRecord;
import com.huike.business.domain.vo.BusinessTrackVo;
import com.huike.business.service.ITbBusinessService;
import com.huike.business.service.ITbBusinessTrackRecordService;
import com.huike.clues.service.ISysDictDataService;
import com.huike.common.annotation.Log;
import com.huike.common.core.controller.BaseController;
import com.huike.common.core.domain.AjaxResult;
import com.huike.common.enums.BusinessType;
import com.huike.common.utils.DateUtils;
import com.huike.common.utils.SecurityUtils;

/**
 * 商机跟进记录Controller
 * @date 2021-04-28
 */
@RestController
@RequestMapping("/business/record")
public class TbBusinessTrackRecordController extends BaseController {

    @Autowired
    private ITbBusinessTrackRecordService tbBusinessTrackRecordService;

    @Autowired
    private ISysDictDataService sysDictDataService;

    /**
     * 查询商机跟进记录列表
     */
    @PreAuthorize("@ss.hasPermi('business:record:list')")
    @GetMapping("/list")
    public  AjaxResult list(@RequestParam("businessId")Long id){
        //查询跟踪记录
        List<TbBusinessTrackRecord> tbBusinessTrackRecord = tbBusinessTrackRecordService.getBusinessTrackRecordByList(id);
        //封装沟通重点数据数据
        setKeys(tbBusinessTrackRecord);
        return AjaxResult.success(tbBusinessTrackRecord);
    }

    /**
     * 封装沟通重点数据数据
     */
    public void setKeys(List<TbBusinessTrackRecord> tbBusinessTrackRecord) {
        for (TbBusinessTrackRecord businessTrackRecord : tbBusinessTrackRecord) {
            //查询沟通重点具体集合
            String communication_point = sysDictDataService.selectDictLabel("communication_point", businessTrackRecord.getKeyItems());
            //转换为集合：小问题：没将字符串转换为集合，直接将字符串赋给了集合的第一个元素
            ArrayList<String> communication_points = new ArrayList<>();
            //封装
            businessTrackRecord.setKeys(communication_points);
        }
    }

    /**
     * 新增商机跟进记录
     */
    @PreAuthorize("@ss.hasPermi('business:record:add')")
    @Log(title = "商机跟进记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessTrackVo businessTrackVo){
        tbBusinessTrackRecordService.addBusinessTrackRecord(businessTrackVo);
        return AjaxResult.success();
    }
}