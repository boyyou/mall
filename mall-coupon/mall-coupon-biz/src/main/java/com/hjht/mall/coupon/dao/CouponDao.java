package com.hjht.mall.coupon.dao;

import com.hjht.mall.coupon.api.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
