package com.hjht.mall.ware.api.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Date 2020/5/26 15:51
 * @Created by ycl
 */
@FeignClient("mall-ware")
public interface WareFeign {
}
