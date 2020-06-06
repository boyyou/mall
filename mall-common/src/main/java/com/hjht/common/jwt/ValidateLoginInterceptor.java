package com.hjht.common.jwt;

import com.alibaba.fastjson.JSONObject;
import com.hjht.common.constant.CodeConstant;
import com.hjht.common.constant.OtherConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Date 2020/5/31 16:27
 * @Created by ycl
 */
@Slf4j
public class ValidateLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //首先从请求头中获取jwt串，与页面约定好存放jwt值的请求头属性名为User-Token
        String jwt = httpServletRequest.getHeader(OtherConstant.ACCESS_TOKEN);
        log.info("[登录校验拦截器]-从header中获取的jwt是:{}", jwt);
        //判断jwt是否有效
        if(StringUtils.isNotBlank(jwt)){
            //校验jwt是否有效,有效则返回json信息，无效则返回空
            String retJson = JwtHelper.validateLogin(jwt);
            log.info("[登录校验拦截器]-校验JWT有效性返回结果:{}", retJson);
            //retJSON为空则说明jwt超时或非法
            if(StringUtils.isNotBlank(retJson)){
            }else {
                log.warn("[登录校验拦截器]-JWT非法或已超时，重新登录");
                //输出响应流
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", CodeConstant.UN_LOGIN);
                jsonObject.put("message", "token非法或已超时，请重新登录!");
                jsonObject.put("data", null);
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setContentType("application/json; charset=utf-8");
                ServletOutputStream outputStream = httpServletResponse.getOutputStream();
                outputStream.write(jsonObject.toJSONString().getBytes("UTF-8"));
                outputStream.close();
            }
        }
        //输出响应流
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", CodeConstant.UN_LOGIN);
        jsonObject.put("message", "未登录!");
        jsonObject.put("data", null);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        outputStream.write(jsonObject.toJSONString().getBytes("UTF-8"));
        outputStream.close();
        return false;
    }
}
