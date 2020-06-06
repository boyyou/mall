package com.hjht.mall.member.api.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Date 2020/5/26 15:30
 * @Created by ycl
 */
@FeignClient("mall-member")
public interface MemberFeign {
}
