package com.hjht.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.coupon.api.entity.SkuFullReductionEntity;

import java.util.Map;
import java.util.List;

/**
 * 商品满减信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存商品满减信息
     * @param  skuFullReductionEntity
     * @return
     */
    Object saveSkuFullReduction(SkuFullReductionEntity skuFullReductionEntity);

    /**
     * 批量删除商品满减信息
     * @param ids
     * @return
     */
    Object deleteBathSkuFullReduction(List<Long> ids);
}

