package com.hjht.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.coupon.api.entity.SkuLadderEntity;

import java.util.Map;
import java.util.List;

/**
 * 商品阶梯价格
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
public interface SkuLadderService extends IService<SkuLadderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存商品阶梯价格
     * @param  skuLadderEntity
     * @return
     */
    Object saveSkuLadder(SkuLadderEntity skuLadderEntity);

    /**
     * 批量删除商品阶梯价格
     * @param ids
     * @return
     */
    Object deleteBathSkuLadder(List<Long> ids);
}

