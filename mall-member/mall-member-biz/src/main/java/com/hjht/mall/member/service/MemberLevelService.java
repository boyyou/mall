package com.hjht.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.member.api.entity.MemberLevelEntity;

import java.util.Map;
import java.util.List;

/**
 * 会员等级
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存会员等级
     * @param  memberLevelEntity
     * @return
     */
    Object saveMemberLevel(MemberLevelEntity memberLevelEntity);

    /**
     * 批量删除会员等级
     * @param ids
     * @return
     */
    Object deleteBathMemberLevel(List<Long> ids);
}

