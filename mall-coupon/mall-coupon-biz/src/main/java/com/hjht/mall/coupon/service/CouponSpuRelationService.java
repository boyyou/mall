package com.hjht.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.coupon.api.entity.CouponSpuRelationEntity;

import java.util.Map;
import java.util.List;

/**
 * 优惠券与产品关联
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
public interface CouponSpuRelationService extends IService<CouponSpuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存优惠券与产品关联
     * @param  couponSpuRelationEntity
     * @return
     */
    Object saveCouponSpuRelation(CouponSpuRelationEntity couponSpuRelationEntity);

    /**
     * 批量删除优惠券与产品关联
     * @param ids
     * @return
     */
    Object deleteBathCouponSpuRelation(List<Long> ids);
}

