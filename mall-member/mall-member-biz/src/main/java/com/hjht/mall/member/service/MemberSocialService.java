package com.hjht.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.member.api.entity.MemberSocialEntity;

import java.util.Map;
import java.util.List;

/**
 * 
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-30 16:41:28
 */
public interface MemberSocialService extends IService<MemberSocialEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 三方账号保存
     * @param  memberSocialEntity
     * @return
     */
    Object saveMemberSocial(MemberSocialEntity memberSocialEntity);

    /**
     * 三方账号批量删除
     * @param ids
     * @return
     */
    Object deleteBathMemberSocial(List<Long> ids);
}

