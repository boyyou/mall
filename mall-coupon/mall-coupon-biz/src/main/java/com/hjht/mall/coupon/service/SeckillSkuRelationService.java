package com.hjht.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.coupon.api.entity.SeckillSkuRelationEntity;

import java.util.Map;
import java.util.List;

/**
 * 秒杀活动商品关联
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
public interface SeckillSkuRelationService extends IService<SeckillSkuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存秒杀活动商品关联
     * @param  seckillSkuRelationEntity
     * @return
     */
    Object saveSeckillSkuRelation(SeckillSkuRelationEntity seckillSkuRelationEntity);

    /**
     * 批量删除秒杀活动商品关联
     * @param ids
     * @return
     */
    Object deleteBathSeckillSkuRelation(List<Long> ids);
}

