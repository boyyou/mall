package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.entity.SkuImagesEntity;

import java.util.List;
import java.util.Map;

/**
 * sku图片
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存sku图片
     * @param  skuImagesEntity
     * @return
     */
    Object saveSkuImages(SkuImagesEntity skuImagesEntity);

    /**
     * 批量删除sku图片
     * @param ids
     * @return
     */
    Object deleteBathSkuImages(List<Long> ids);
}

