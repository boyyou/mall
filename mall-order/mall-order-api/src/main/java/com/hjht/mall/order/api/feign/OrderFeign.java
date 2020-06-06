package com.hjht.mall.order.api.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Date 2020/5/26 15:48
 * @Created by ycl
 */
@FeignClient("mall-order")
public interface OrderFeign {
}
