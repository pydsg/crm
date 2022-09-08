package com.huike.review.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huike.review.pojo.Review;
import com.huike.review.service.ReviewService;
import com.huike.review.mapper.MybatisReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


/**
 * mybatis复习使用的业务层
 * 注意该业务层和我们系统的业务无关，主要是让同学们快速熟悉系统的
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private MybatisReviewMapper reviewMapper;

    /**=========================================================保存数据的方法=============================================*/
    @Override
    public void add(Review review) {

        //补充数据
        review.setCreateTime(new Date());
        review.setCreateBy("马云");
        review.setUpdateBy("马化腾");
        review.setUpdateTime(new Date());

        reviewMapper.add(review);
    }

    /**=========================================================删除数据=============================================*/
    @Override
    public void update(Review review) {
        reviewMapper.update(review);
    }

    /**=========================================================修改数据=============================================*/
    @Override
    public void Delete(Long id) {
        reviewMapper.delete(id);
    }

    /**=========================================================查询数据的方法=============================================*/
    @Override
    public Review FindById(Long id) {
        return reviewMapper.FindById(id);
    }

    /**=========================================================分页查询数据=============================================*/
    @Override
    public PageInfo<Review> getDataByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Review> dataByPage = reviewMapper.getDataByPage();
        PageInfo<Review> reviewPageInfo = new PageInfo<>(dataByPage);

        return reviewPageInfo;
    }

}
