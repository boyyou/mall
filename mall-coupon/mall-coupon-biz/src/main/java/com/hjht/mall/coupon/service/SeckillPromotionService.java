package com.hjht.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.coupon.api.entity.SeckillPromotionEntity;

import java.util.Map;
import java.util.List;

/**
 * 秒杀活动
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存秒杀活动
     * @param  seckillPromotionEntity
     * @return
     */
    Object saveSeckillPromotion(SeckillPromotionEntity seckillPromotionEntity);

    /**
     * 批量删除秒杀活动
     * @param ids
     * @return
     */
    Object deleteBathSeckillPromotion(List<Long> ids);
}

