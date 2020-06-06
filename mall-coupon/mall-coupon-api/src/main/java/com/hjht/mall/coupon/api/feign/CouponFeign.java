package com.hjht.mall.coupon.api.feign;

import com.hjht.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Date 2020/5/26 9:50
 * @Created by ycl
 */
@FeignClient("mall-coupon")
public interface CouponFeign {

    @GetMapping("/coupon/coupon/list/cou")
    R list();

}
