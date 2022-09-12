package com.huike.web.controller.report;


import com.huike.report.domain.vo.BusinessChangeStatisticsVo;
import com.huike.report.domain.vo.IndexTodayInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huike.common.core.domain.AjaxResult;
import com.huike.report.service.IReportService;

import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IReportService reportService;

    /**
     * 首页--基础数据统计
     * @param beginCreateTime
     * @param endCreateTime
     * @return
     */
    @GetMapping("/getBaseInfo")
    public AjaxResult getBaseInfo(@RequestParam("beginCreateTime") String beginCreateTime,
                                  @RequestParam("endCreateTime") String endCreateTime){
        return AjaxResult.success(reportService.getBaseInfo(beginCreateTime,endCreateTime));
    }

    /**
     * 获取今日简报数据
     * @return
     */
    @GetMapping("/getTodayInfo")
    public AjaxResult getTodayInfo(){
        return AjaxResult.success(reportService.getIndexTodoInfo());
    }

    /**
     * 待办事项
     * @return
     */
    @GetMapping("/getTodoInfo")
    public AjaxResult getTodoInfo(@RequestParam(value = "beginCreateTime", required = false) String beginCreateTime,
                                   @RequestParam(value = "endCreateTime", required = false) String endCreateTime){
        return AjaxResult.success(reportService.getIndexTodayInfo(beginCreateTime,endCreateTime));
    }

    /**
     * 商机转换龙虎榜
     * @param beginCreateTime
     * @param endCreateTime
     * @return
     */
    @GetMapping("/businessChangeStatistics")
    public AjaxResult getBusinessChangeStatistics(@RequestParam("beginCreateTime") String beginCreateTime,
                                                  @RequestParam("endCreateTime") String endCreateTime) {

        return AjaxResult.success(reportService.getBusinessChangeStatistics(beginCreateTime, endCreateTime));
    }

    /**
     * 线索转换
     * @param beginCreateTime
     * @param endCreateTime
     * @return
     */
    @GetMapping("/salesStatistic")
    public AjaxResult getsalesStatistic(@RequestParam("beginCreateTime") String beginCreateTime,
                                                  @RequestParam("endCreateTime") String endCreateTime) {
        return AjaxResult.success(reportService.getsalesStatistic(beginCreateTime, endCreateTime));
    }
}
