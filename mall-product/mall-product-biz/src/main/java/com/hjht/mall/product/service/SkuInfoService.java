package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.entity.SkuInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * sku信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存sku信息
     * @param  skuInfoEntity
     * @return
     */
    Object saveSkuInfo(SkuInfoEntity skuInfoEntity);

    /**
     * 批量删除sku信息
     * @param skuIds
     * @return
     */
    Object deleteBathSkuInfo(List<Long> skuIds);
}

