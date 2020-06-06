package com.hjht.mall.ware.api.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * 仓储服务异常枚举
 * @Date 2020/5/29 16:31
 * @Created by ycl
 */
public enum  ExceptionConstant {

    BASE_EXCEPTION(50000,"系统繁忙，请稍后!");

    @Getter
    @Setter
    private Integer code;

    @Getter
    @Setter
    private String message;

    ExceptionConstant(Integer code,String message){
        this.code = code;
        this.message = message;
    }

}
