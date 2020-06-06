package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.entity.SkuSaleAttrValueEntity;

import java.util.List;
import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存sku销售属性&值
     * @param  skuSaleAttrValueEntity
     * @return
     */
    Object saveSkuSaleAttrValue(SkuSaleAttrValueEntity skuSaleAttrValueEntity);

    /**
     * 批量删除sku销售属性&值
     * @param ids
     * @return
     */
    Object deleteBathSkuSaleAttrValue(List<Long> ids);
}

