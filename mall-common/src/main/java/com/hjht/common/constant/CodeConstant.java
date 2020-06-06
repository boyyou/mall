package com.hjht.common.constant;

/**
 * @Date 2020/5/26 9:39
 * @Created by ycl
 * 返回编码常量
 * 每个系统的错误码请以规定前缀开头：coupon:10000,member:20000,order:30000,product:40000,ware:50000,sso:60000,three:70000
 */
public class CodeConstant {

    /**
     * 成功code标识
     */
    public static final int SUCCESS = 0;

    /**
     * 失败code标识
     */
    public static final int FAIL = 1;

    /**
     * 消息提示成功
     */
    public static final String OK_MSG = "OK";

    /**
     * 消息提示失败
     */
    public static final String FAIL_MSG = "FAIL";

    //1-QQ
    public static final Integer QQ = 1;
    //2-微信
    public static final Integer WX = 2;
    //3-支付宝
    public static final Integer A_LI_PAY = 3;
    //4-微博
    public static final Integer WEI_BO = 4;
    //5-抖音
    public static final Integer DOU_YIN = 5;
    //6-头条
    public static final Integer TOU_TIAO = 6;
    //未登录状态码
    public static final String UN_LOGIN = "401";

}
