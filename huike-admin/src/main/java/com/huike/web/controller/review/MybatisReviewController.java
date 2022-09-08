package com.huike.web.controller.review;


import com.github.pagehelper.PageInfo;
import com.huike.common.core.controller.BaseController;
import com.huike.common.core.domain.AjaxResult;
import com.huike.review.pojo.Review;
import com.huike.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 该Controller主要是为了复习三层架构以及Mybatis使用的，该部分接口已经放开权限，可以直接访问
 * 同学们在此处编写接口通过浏览器访问看是否能完成最简单的增删改查
 */
@RestController
@RequestMapping("/review")
public class MybatisReviewController extends BaseController {

    @Autowired
    private ReviewService reviewService;

    /**=========================================================新增数据============================================*/
    @PostMapping("/saveData")
    public AjaxResult add(@RequestBody Review review) {
        reviewService.add(review);
        return AjaxResult.success("成功插入:1条数据");
    }

    /**=========================================================删除数据=============================================*/
    @PostMapping("/update")
    public AjaxResult update(@RequestBody Review review) {
        reviewService.update(review);
        return AjaxResult.success("修改成功");
    }

    /**=========================================================修改数据=============================================*/
    @DeleteMapping("/remove/{id}")
    public AjaxResult Delete(@PathVariable Long id) {
        reviewService.Delete(id);
        return AjaxResult.success("修改成功");
    }

    /**=========================================================查询数据=============================================*/
    @GetMapping("/getById")
    public AjaxResult findById(Long id) {
        Review review = reviewService.FindById(id);
        return AjaxResult.success(review);
    }

    /**=========================================================分页查询数据=============================================*/
    @GetMapping("/getDataByPage")
    public AjaxResult getDataByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "5") Integer pageSize) {
        PageInfo<Review> reviewPage = reviewService.getDataByPage(pageNum, pageSize);
        return AjaxResult.success(reviewPage);
    }

}