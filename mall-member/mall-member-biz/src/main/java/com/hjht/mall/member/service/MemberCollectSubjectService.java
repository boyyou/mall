package com.hjht.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.member.api.entity.MemberCollectSubjectEntity;

import java.util.Map;
import java.util.List;

/**
 * 会员收藏的专题活动
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存会员收藏的专题活动
     * @param  memberCollectSubjectEntity
     * @return
     */
    Object saveMemberCollectSubject(MemberCollectSubjectEntity memberCollectSubjectEntity);

    /**
     * 批量删除会员收藏的专题活动
     * @param ids
     * @return
     */
    Object deleteBathMemberCollectSubject(List<Long> ids);
}

