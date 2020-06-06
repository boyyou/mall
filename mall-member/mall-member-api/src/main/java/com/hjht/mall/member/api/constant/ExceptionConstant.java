package com.hjht.mall.member.api.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户服务异常枚举
 * @Date 2020/5/29 16:26
 * @Created by ycl
 */
public enum  ExceptionConstant {
    BASE_EXCEPTION(20000,"系统繁忙，请稍后!");

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
