package com.hjht.common.jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Date 2020/5/31 16:30
 * @Created by ycl
 * 注册自定义的拦截类
 */
@Configuration
public class InterceptConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] path = new String[]{"/member/member/send/sms","/member/member/login","/member/member/register"};
        registry.addInterceptor(new ValidateLoginInterceptor()).addPathPatterns(path);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
