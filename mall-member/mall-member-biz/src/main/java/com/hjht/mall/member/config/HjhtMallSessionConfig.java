package com.hjht.mall.member.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Date 2020/5/31 9:42
 * @Created by ycl
 * cookie配置类，导入spring-session-data-redis和spring-boot-starter-data-redis这两个jar包
 * 然后yml配置
 * spring:
 *   redis:
 *     host: 47.114.109.117
 *     port: 10001
 *     password: hyredis2020
 *   session:
 *     store-type: redis
 *
 * server:
 *   servlet:
 *     session:
 *       timeout: 30m
 *  这个用来配置session的过期时间，默认也是30分钟
 * 然后启动类添加了注解@EnableRedisHttpSession之后这样就指定了将session存储在redis中了就可以直接使用
 * HttpSession session = request.getSession();
 *         session.setAttribute("ycl","123");设置登陆后的session放在redis中了，其他模块控制器通过
 *         HttpSession session = request.getSession();
 *         Object ycl = session.getAttribute("ycl");就可以获取登陆的session了
 * 以上配置之后就可以将登陆后的session不存储在tomcat中而是存储在redis中了，其他服务也能获取到session
 * 但是有个问题，因为session放在浏览器中的cookie默认的作用域是当前域名，如果其他模块跨域的话就无法获取了，因此以下编写的配置类就是修改
 * session的作用域为hjht.com顶级域名那么比如user.hjht.com，order.hjht.com都可以获取到session了,这个类的配置和以上的导包和配置都需要在
 * 其他模块编写，只是session过期时间的配置只需要在登录模块配置就行了，其他模块不需要
 * //TODO 暂时弃用通过spring的session redis保存用户信息
 */
//@Configuration
public class HjhtMallSessionConfig {

    /**
     * 修改session作用域
     * @return
     */
    /*@Bean
    public CookieSerializer cookieSerializer(){
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();
        //TODO 后期确定了域名需要修改，暂定如此
        //defaultCookieSerializer.setDomainName(RedisConstant.TOP_DOMAIN_NAME);
        defaultCookieSerializer.setCookieName("HJHTSESSION");
        return cookieSerializer();
    }*/



    /**
     * 指定redis的序列化使用阿里的fastjson
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        // 全局开启AutoType，不建议使用
        // ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        // 建议使用这种方式，小范围指定白名单
        //ParserConfig.getGlobalInstance().addAccept("com.longge.");

        // 设置值（value）的序列化采用FastJsonRedisSerializer。
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
        // 设置键（key）的序列化采用StringRedisSerializer。
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
