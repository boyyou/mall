package com.hjht.mall.ware;

import com.hjht.common.annotations.EnableHjhtFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHjhtFeignClients
public class MallWareBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWareBizApplication.class, args);
    }

}
