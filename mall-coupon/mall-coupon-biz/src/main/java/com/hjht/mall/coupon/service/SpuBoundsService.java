package com.hjht.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.coupon.api.entity.SpuBoundsEntity;

import java.util.Map;
import java.util.List;

/**
 * 商品spu积分设置
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
public interface SpuBoundsService extends IService<SpuBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存商品spu积分设置
     * @param  spuBoundsEntity
     * @return
     */
    Object saveSpuBounds(SpuBoundsEntity spuBoundsEntity);

    /**
     * 批量删除商品spu积分设置
     * @param ids
     * @return
     */
    Object deleteBathSpuBounds(List<Long> ids);
}

