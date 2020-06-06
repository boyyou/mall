package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.entity.CommentReplayEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存商品评价回复关系
     * @param  commentReplayEntity
     * @return
     */
    Object saveCommentReplay(CommentReplayEntity commentReplayEntity);

    /**
     * 批量删除商品评价回复关系
     * @param ids
     * @return
     */
    Object deleteBathCommentReplay(List<Long> ids);
}

