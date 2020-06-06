package com.hjht.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.coupon.api.entity.HomeSubjectSpuEntity;

import java.util.Map;
import java.util.List;

/**
 * 专题商品
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存专题商品
     * @param  homeSubjectSpuEntity
     * @return
     */
    Object saveHomeSubjectSpu(HomeSubjectSpuEntity homeSubjectSpuEntity);

    /**
     * 批量删除专题商品
     * @param ids
     * @return
     */
    Object deleteBathHomeSubjectSpu(List<Long> ids);
}

