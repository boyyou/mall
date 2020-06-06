package com.hjht.mall.product;

import com.hjht.common.annotations.EnableHjhtFeignClients;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHjhtFeignClients
public class MallProductBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProductBizApplication.class, args);
    }

}
