package com.hjht.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.member.api.entity.MemberReceiveAddressEntity;

import java.util.Map;
import java.util.List;

/**
 * 会员收货地址
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:25
 */
public interface MemberReceiveAddressService extends IService<MemberReceiveAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存会员收货地址
     * @param  memberReceiveAddressEntity
     * @return
     */
    Object saveMemberReceiveAddress(MemberReceiveAddressEntity memberReceiveAddressEntity);

    /**
     * 批量删除会员收货地址
     * @param ids
     * @return
     */
    Object deleteBathMemberReceiveAddress(List<Long> ids);
}

