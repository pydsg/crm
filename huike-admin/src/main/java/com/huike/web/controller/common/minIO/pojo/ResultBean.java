package com.huike.web.controller.common.minIO.pojo;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class ResultBean<T> {

    private Integer code;

    private String msg;

    private T data;

    public static ResultBean newInstance() {
        return new ResultBean();
    }


    public ResultBean ok(String msg, T data){
        this.code = 200;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public ResultBean error(String msg){
        this.code = 500;
        this.msg = msg;
        return this;
    }
}
