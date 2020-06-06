package com.hjht.mall.order.config;

import com.hjht.common.jwt.ValidateLoginInterceptor;
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
    //将之前自定义的拦截类注册在spring中，因为这是写在common中的，需要我们手动去添加到spring容器中，利用springboot的start即在classpath目录下的META-INF中的spring.factories中配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //1.我们需要排除登录,和注册的拦截以及取消拦截静态资源的访问
        //String[] exclude = new String[]{"/doc.html","/member/member/send/sms","/member/member/login","/member/member/register"};
        //2.需要进行拦截的路径
        String[] path = new String[]{"/member/member/send/sms","/member/member/login","/member/member/register"};
        //1.需要对我们自定义的拦截器ValidateLoginInterceptor进行注册/**是拦截所有的请求，将上面1配置的路径排除，不进行拦截
        //registry.addInterceptor(new ValidateLoginInterceptor()).addPathPatterns("/**").excludePathPatterns(exclude);//拦截路径
        //2.和上面的2对应配置需要拦截的路径
        registry.addInterceptor(new ValidateLoginInterceptor()).addPathPatterns(path);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
