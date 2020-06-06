package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.entity.SpuImagesEntity;

import java.util.List;
import java.util.Map;

/**
 * spu图片
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存spu图片
     * @param  spuImagesEntity
     * @return
     */
    Object saveSpuImages(SpuImagesEntity spuImagesEntity);

    /**
     * 批量删除spu图片
     * @param ids
     * @return
     */
    Object deleteBathSpuImages(List<Long> ids);

    void saveSpuImagesBath(Long id, List<String> images);
}

