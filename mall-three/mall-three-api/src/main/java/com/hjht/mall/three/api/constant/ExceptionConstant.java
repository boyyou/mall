package com.hjht.mall.three.api.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * 三方服务异常枚举
 * @Date 2020/5/29 16:30
 * @Created by ycl
 */
public enum ExceptionConstant {
    BASE_EXCEPTION(70000,"系统繁忙，请稍后!"),
    VERIFICATION_CODE(70001,"验证码发送频繁!");

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
