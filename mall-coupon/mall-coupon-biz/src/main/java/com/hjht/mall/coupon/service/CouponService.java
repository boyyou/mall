package com.hjht.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.coupon.api.entity.CouponEntity;

import java.util.Map;
import java.util.List;

/**
 * 优惠券信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存优惠券信息
     * @param  couponEntity
     * @return
     */
    Object saveCoupon(CouponEntity couponEntity);

    /**
     * 批量删除优惠券信息
     * @param ids
     * @return
     */
    Object deleteBathCoupon(List<Long> ids);
}

