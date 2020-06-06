package com.hjht.mall.member;

import com.hjht.common.annotations.EnableHjhtFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHjhtFeignClients
public class MallMemberBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallMemberBizApplication.class, args);
    }

}
