package com.hjht.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.coupon.api.entity.HomeAdvEntity;

import java.util.Map;
import java.util.List;

/**
 * 首页轮播广告
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
public interface HomeAdvService extends IService<HomeAdvEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存首页轮播广告
     * @param  homeAdvEntity
     * @return
     */
    Object saveHomeAdv(HomeAdvEntity homeAdvEntity);

    /**
     * 批量删除首页轮播广告
     * @param ids
     * @return
     */
    Object deleteBathHomeAdv(List<Long> ids);
}

