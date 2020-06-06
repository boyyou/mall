package com.hjht.mall.product.api.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Date 2020/5/26 15:50
 * @Created by ycl
 */
@FeignClient("mall-product")
public interface ProductFeign {
}
