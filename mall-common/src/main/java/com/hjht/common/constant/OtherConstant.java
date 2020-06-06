package com.hjht.common.constant;

/**
 * @Date 2020/5/29 19:14
 * @Created by ycl
 */
public class OtherConstant {
    //系统短信验证码长度
    public static final String SMS_DEFAULT_LENGTH = "4";
    //小程序授权类型
    public static final String GRANT_TYPE = "authorization_code";

    //jwt签名秘钥
    public static final String BASE64SECRET = "hjht-mall";

    //超时毫秒数（默认30分钟）
    //public static final int EXPRIE_SECOND = 1800000;

    //超时毫秒数（默认5小时）
    public static final int EXPRIE_SECOND = 18000000;

    //微信小程序登陆，sessionkey的过期时间
    public static final int EXPRIE_SESSION_KEY = 7200;

    //标记token类型  1标识用户表的member账号密码登陆
    public static final int TOKEN_TYPE_MEMBER = 1;

    //标记token类型  2标识三方账号表，如qq，微信等登陆
    public static final int TOKEN_TYPE_SOCIAL = 2;

    //用于JWT加密的密匙
    public static final String DATAKEY = "hjht-mall";

    //用户登陆标记
    public static final String ACCESS_TOKEN = "accessToken";

    //请求头中浏览器信息
    public static final String USER_AGENT = "User-Agent";

    //token中的浏览器信息
    public static final String USER_AGENT_TOKEN = "userAgent";

    //登陆的用户姓名
    public static final String USER_NAME = "userName";

    //登陆用户id
    public static final String USER_ID = "userId";
}
