package com.hjht.common.token;

import com.hjht.common.constant.RedisConstant;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.digests.MD5Digest;

/**
 * @Date 2020/6/1 9:54
 * @Created by ycl
 * 生成token
 */
public class TokenUtil {
    /**
     * 生成token方法
     * @return
     */
    public static String generToken(String id){
        StringBuilder stringBuilder = new StringBuilder(RedisConstant.TOKEN_CLIENT_PRE);
        stringBuilder.append(id).append(System.currentTimeMillis());
        String token = DigestUtils.md5Hex(stringBuilder.toString());
        return token;
    }
}
