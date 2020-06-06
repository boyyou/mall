package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.entity.SpuInfoEntity;
import com.hjht.mall.product.api.vo.SpuSaveVo;

import java.util.List;
import java.util.Map;

/**
 * spu信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存spu信息
     * @param  spuSaveVo
     * @return
     */
    Object saveSpuInfo(SpuSaveVo spuSaveVo);


    /**
     * 批量删除spu信息
     * @param ids
     * @return
     */
    Object deleteBathSpuInfo(List<Long> ids);
}

