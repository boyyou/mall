package com.hjht.common.constant;

/**
 * 整个系统中关于redis缓存的前缀，每个服务请以每个服务名字开头，如：mall-pms  PRODUCT
 * @Date 2020/5/29 16:01
 * @Created by ycl
 */
public class RedisConstant {
    //单点登陆短信验证码
    public final static String SSO_SMS_CODE = "SSO_SMS_CODE@";

    //单点登陆验证码缓存时长，单位秒
    public final static Integer SSO_CACHE_TIME = 600;

    //验证码默认的发送间隔时长，单位秒
    public final static Integer DEFAULT_INTERVAL = 60;

    //登陆的用户存储在中的标记
    public final static String SESSION_NAME = "loginUser";

    //顶级域名
    public final static String TOP_DOMAIN_NAME = "hjht.com";

    //token前缀
    public final static String TOKEN_CLIENT_PRE = "TOKEN:CLIENT@";
}
