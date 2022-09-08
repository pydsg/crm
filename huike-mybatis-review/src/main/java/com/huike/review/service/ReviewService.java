package com.huike.review.service;

import com.github.pagehelper.PageInfo;
import com.huike.review.pojo.Review;

/**
 * mybatis复习接口层
 */
public interface ReviewService {
    void add(Review review);

    void update(Review review);

    void Delete(Long id);

    Review FindById(Long id);

    PageInfo<Review> getDataByPage(Integer pageNum, Integer pageSize);
}
