package com.hjht.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hjht.common.constant.OtherConstant;
import com.hjht.common.entity.CommonUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date 2020/6/1 17:33
 * @Created by ycl
 */
@Component
public class MemberUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    public CommonUser getUser(){
        //获取这个请求的request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取请求所携带的token
        String header = request.getHeader(OtherConstant.ACCESS_TOKEN);
        CommonUser commonUser = null;
        //通过token去redis中获取用户数据
        commonUser= (CommonUser) redisTemplate.opsForValue().get(header+"_"+OtherConstant.TOKEN_TYPE_MEMBER);
        if (commonUser == null){
            //通过token去redis中获取用户数据
            commonUser = (CommonUser) redisTemplate.opsForValue().get(header+"_"+OtherConstant.TOKEN_TYPE_SOCIAL);
        }
        return commonUser;
    }
}
