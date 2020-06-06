package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.entity.BrandEntity;

import java.util.List;
import java.util.Map;

/**
 * 品牌
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存品牌
     * @param  brandEntity
     * @return
     */
    Object saveBrand(BrandEntity brandEntity);

    /**
     * 批量删除品牌
     * @param brandIds
     * @return
     */
    Object deleteBathBrand(List<Long> brandIds);
}

