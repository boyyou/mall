package com.hjht.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.member.api.entity.MemberLoginLogEntity;

import java.util.Map;
import java.util.List;

/**
 * 会员登录记录
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
public interface MemberLoginLogService extends IService<MemberLoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存会员登录记录
     * @param  memberLoginLogEntity
     * @return
     */
    Object saveMemberLoginLog(MemberLoginLogEntity memberLoginLogEntity);

    /**
     * 批量删除会员登录记录
     * @param ids
     * @return
     */
    Object deleteBathMemberLoginLog(List<Long> ids);
}

