package com.hjht.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.member.api.entity.MemberCollectSpuEntity;

import java.util.Map;
import java.util.List;

/**
 * 会员收藏的商品
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
public interface MemberCollectSpuService extends IService<MemberCollectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存会员收藏的商品
     * @param  memberCollectSpuEntity
     * @return
     */
    Object saveMemberCollectSpu(MemberCollectSpuEntity memberCollectSpuEntity);

    /**
     * 批量删除会员收藏的商品
     * @param ids
     * @return
     */
    Object deleteBathMemberCollectSpu(List<Long> ids);
}

