package com.hjht.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.coupon.api.entity.CouponHistoryEntity;

import java.util.Map;
import java.util.List;

/**
 * 优惠券领取历史记录
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
public interface CouponHistoryService extends IService<CouponHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存优惠券领取历史记录
     * @param  couponHistoryEntity
     * @return
     */
    Object saveCouponHistory(CouponHistoryEntity couponHistoryEntity);

    /**
     * 批量删除优惠券领取历史记录
     * @param ids
     * @return
     */
    Object deleteBathCouponHistory(List<Long> ids);
}

