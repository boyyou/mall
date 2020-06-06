package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.entity.ProductAttrValueEntity;

import java.util.List;
import java.util.Map;

/**
 * spu属性值
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存spu属性值
     * @param  productAttrValueEntity
     * @return
     */
    Object saveProductAttrValue(ProductAttrValueEntity productAttrValueEntity);

    /**
     * 批量删除spu属性值
     * @param ids
     * @return
     */
    Object deleteBathProductAttrValue(List<Long> ids);
}

