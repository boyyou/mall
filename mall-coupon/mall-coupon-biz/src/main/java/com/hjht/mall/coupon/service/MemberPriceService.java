package com.hjht.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.coupon.api.entity.MemberPriceEntity;

import java.util.Map;
import java.util.List;

/**
 * 商品会员价格
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存商品会员价格
     * @param  memberPriceEntity
     * @return
     */
    Object saveMemberPrice(MemberPriceEntity memberPriceEntity);

    /**
     * 批量删除商品会员价格
     * @param ids
     * @return
     */
    Object deleteBathMemberPrice(List<Long> ids);
}

