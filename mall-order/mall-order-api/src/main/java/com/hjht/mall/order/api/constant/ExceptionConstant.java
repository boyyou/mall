package com.hjht.mall.order.api.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单系统异常枚举
 * @Date 2020/5/29 16:28
 * @Created by ycl
 */
public enum ExceptionConstant {
    BASE_EXCEPTION(30000,"系统繁忙，请稍后!");

    @Getter
    @Setter
    private Integer code;

    @Getter
    @Setter
    private String message;

    ExceptionConstant(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
