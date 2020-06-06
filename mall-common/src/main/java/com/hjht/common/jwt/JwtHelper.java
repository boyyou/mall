package com.hjht.common.jwt;

/**
 * @Date 2020/5/31 16:22
 * @Created by ycl
 */

import com.alibaba.fastjson.JSONObject;
import com.hjht.common.constant.OtherConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: JWT工具类
 * 参考官网：https://jwt.io/
 * JWT的数据结构为：A.B.C三部分数据，由字符点"."分割成三部分数据
 * A-header头信息
 * B-payload 有效负荷 一般包括：已注册信息（registered claims），公开数据(public claims)，私有数据(private claims)
 * C-signature 签名信息 是将header和payload进行加密生成的
 */
public class JwtHelper {

    private static Logger logger = LoggerFactory.getLogger(JwtHelper.class);

    /**
     * @param userId     - 用户id
     * @param userName   - 用户名称
     * @param identities - 用户端信息（变长参数），目前包含浏览器信息，用于客户端拦截器校验，防止跨域非法访问
     * @Description: 生成JWT字符串
     * 格式：A.B.C
     * A-header头信息
     * B-payload 有效负荷
     * C-signature 签名信息 是将header和payload进行加密生成的
     */
    public static String generateJWT(String userId, String userName, String... identities) {
        //签名算法，选择SHA-256
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //获取当前系统时间
        long nowTimeMillis = System.currentTimeMillis();
        Date now = new Date(nowTimeMillis);
        //将BASE64SECRET常量字符串使用base64解码成字节数组
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(OtherConstant.BASE64SECRET);
        //使用HmacSHA256签名算法生成一个HS256的签名秘钥Key
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        //添加构成JWT的参数
        Map<String, Object> headMap = new HashMap<>();
        /*
            Header
            {
              "alg": "HS256",
              "typ": "JWT"
            }
         */
        headMap.put("alg", SignatureAlgorithm.HS256.getValue());
        headMap.put("typ", "JWT");
        JwtBuilder builder = Jwts.builder().setHeader(headMap)
                /*
                    Payload
                    {
                      "userId": "1234567890",
                      "userName": "John Doe",
                    }
                 */
                //加密后的用户id
                .claim(OtherConstant.USER_ID, AESSecretUtil.encryptToStr(userId, OtherConstant.DATAKEY))
                //用户名称
                .claim(OtherConstant.USER_NAME, userName)
                //用户端浏览器信息
                .claim(OtherConstant.USER_AGENT_TOKEN, identities[0])
                //Signature
                .signWith(signatureAlgorithm, signingKey);
        //添加Token过期时间
        if (OtherConstant.EXPRIE_SECOND >= 0) {
            long expMillis = nowTimeMillis + OtherConstant.EXPRIE_SECOND;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate).setNotBefore(now);
        }
        return builder.compact();
    }

    /**
     * @param jsonWebToken - JWT
     * @Description: 解析JWT字符串
     * 返回Claims对象
     */
    public static Claims parseJWT(String jsonWebToken) {
        Claims claims = null;
        try {
            if (StringUtils.isNotBlank(jsonWebToken)) {
                //解析jwt
                claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(OtherConstant.BASE64SECRET))
                        .parseClaimsJws(jsonWebToken).getBody();
            } else {
                logger.warn("[JWTHelper]-json web token 为空");
            }
        } catch (Exception e) {
            logger.error("[JWTHelper]-JWT解析异常：可能因为token已经超时或非法token");
        }
        return claims;
    }

    /**
     * @param jsonWebToken - JWT
     * @Description: 校验JWT是否有效
     * 返回json字符串的demo:
     * {"freshToken":"A.B.C","userName":"Judy","userId":"123", "userAgent":"xxxx"}
     * freshToken-刷新后的jwt
     * userName-客户名称
     * userId-客户编号
     * userAgent-客户端浏览器信息
     */
    public static String validateLogin(String jsonWebToken) {
        Map<String, Object> retMap = null;
        Claims claims = parseJWT(jsonWebToken);
        if (claims != null) {
            //解密客户编号
            String decryptUserId = AESSecretUtil.decryptToStr((String) claims.get(OtherConstant.USER_ID), OtherConstant.DATAKEY);
            retMap = new HashMap<>();
            //加密后的客户编号
            retMap.put(OtherConstant.USER_ID, decryptUserId);
            //客户名称
            retMap.put(OtherConstant.USER_NAME, claims.get(OtherConstant.USER_NAME));
            //客户端浏览器信息
            retMap.put(OtherConstant.USER_AGENT_TOKEN, claims.get(OtherConstant.USER_AGENT_TOKEN));
            //刷新JWT
            retMap.put("freshToken", generateJWT(decryptUserId, (String) claims.get(OtherConstant.USER_NAME), (String) claims.get(OtherConstant.USER_AGENT_TOKEN), (String) claims.get("domainName")));
        } else {
            logger.info("[JWTHelper]-JWT解析出claims为空");
        }
        return retMap != null ? JSONObject.toJSONString(retMap) : null;
    }

    /*public static void main(String[] args) {
        String jsonWebKey = generateJWT("123", "Judy",
                "");
        System.out.println(jsonWebKey);
        Claims claims = parseJWT(jsonWebKey);
        System.out.println(claims);
        System.out.println(validateLogin(jsonWebKey));
    }*/
}
