package com.hjht.mall.coupon;

import com.hjht.common.annotations.EnableHjhtFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHjhtFeignClients
@EnableRedisHttpSession
public class MallCouponBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallCouponBizApplication.class, args);
    }

}
