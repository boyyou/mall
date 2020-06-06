package com.hjht.mall.member.config;

import com.alibaba.fastjson.JSONObject;
import com.hjht.common.constant.CodeConstant;
import com.hjht.common.constant.OtherConstant;
import com.hjht.common.entity.CommonUser;
import com.hjht.common.jwt.JwtHelper;
import com.hjht.common.utils.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Date 2020/5/31 16:27
 * @Created by ycl
 * 自定义拦截器对注册符合条件的url进行拦截做如下处理，注册拦截器是在com.hjht.common.jwt.InterceptConfig中
 */
@Slf4j
@Component
public class ValidateLoginInterceptor extends  HandlerInterceptorAdapter {

    /**
     * 需要注意一个问题我们在拦截器里面直接注入bean比如：redisTemplate，当请求拦截之后运行当前拦截器的时候redisTemplate是一个null
     * 因为springboot拦截器是在Bean实例化之前执行的，所以Bean实例无法注入，是一个null，那么我们就需要让springboot拦截器在实例化的时候就
     * 注入bean，做法的关键点就是当前包下InterceptConfig类中在配置拦截路劲的时候
     *     @Bean
     *     public ValidateLoginInterceptor getAccessLimitIntercept() {
     *         return new ValidateLoginInterceptor();
     *     }
     *     先实例化我们这个拦截器，那么这时就会把redisTemplate注入
     *     然后registry.addInterceptor(getAccessLimitIntercept()).addPathPatterns(path);
     *     因为getAccessLimitIntercept()方法返回的是一个被@Bean注解标注的实体，而返回的类是我们当前拦截器类型的对象，所以我们就将
     *     我们当前拦截器注入到ioc中同时注入redisTemplate，就不会产生null了，当然我们可以把这两个类配置到common中，我们的每一个服务
     *     导入了common包，所以这样对每一个服务都配置了拦截器，在这两个类中根据要拦截的路径配置即可，要想这个拦截器生效同样要让他springboot start
     *     在spring.factories里面配置InterceptConfig类的全路径即可,https://blog.csdn.net/zxl646801924/article/details/99544463
     *     因为每个服务要拦截的路径会不一样，所以最好是每个服务都分别配置
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //首先从请求头中获取jwt串，与页面约定好存放jwt值的请求头属性名为User-Token
        String token = httpServletRequest.getHeader(OtherConstant.ACCESS_TOKEN);
        if (token == null){
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
        CommonUser o1 = (CommonUser)redisTemplate.opsForValue().get(token+"_"+OtherConstant.TOKEN_TYPE_MEMBER);
        if (o1 == null){
            o1 = (CommonUser)redisTemplate.opsForValue().get(token+"_"+OtherConstant.TOKEN_TYPE_SOCIAL);
        }
        log.info("[登录校验拦截器]-从header中获取的token是:{}", token);
        if (StringUtils.isNotEmpty(token) && o1 != null){
            return Boolean.TRUE;
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
