package com.hjht.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.coupon.api.entity.CouponSpuCategoryRelationEntity;

import java.util.Map;
import java.util.List;

/**
 * 优惠券分类关联
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
public interface CouponSpuCategoryRelationService extends IService<CouponSpuCategoryRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存优惠券分类关联
     * @param  couponSpuCategoryRelationEntity
     * @return
     */
    Object saveCouponSpuCategoryRelation(CouponSpuCategoryRelationEntity couponSpuCategoryRelationEntity);

    /**
     * 批量删除优惠券分类关联
     * @param ids
     * @return
     */
    Object deleteBathCouponSpuCategoryRelation(List<Long> ids);
}

