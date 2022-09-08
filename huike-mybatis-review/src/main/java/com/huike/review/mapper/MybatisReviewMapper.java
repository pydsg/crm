package com.huike.review.mapper;

import com.huike.review.pojo.Review;

import java.util.List;

/**
 * Mybatis复习的Mapper层
 */
public interface MybatisReviewMapper {

    /**======================================================新增======================================================**/
    void add(Review review);

    /**======================================================删除======================================================**/
    void update(Review review);

    /**======================================================修改======================================================**/
    void delete(Long id);

    /**======================================================简单查询===================================================**/
    Review FindById(Long id);

    /**=========================================================分页查询数据=============================================*/
    List<Review> getDataByPage();


}
