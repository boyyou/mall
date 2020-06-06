package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.entity.SpuCommentEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品评价
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存商品评价
     * @param  spuCommentEntity
     * @return
     */
    Object saveSpuComment(SpuCommentEntity spuCommentEntity);

    /**
     * 批量删除商品评价
     * @param ids
     * @return
     */
    Object deleteBathSpuComment(List<Long> ids);
}

