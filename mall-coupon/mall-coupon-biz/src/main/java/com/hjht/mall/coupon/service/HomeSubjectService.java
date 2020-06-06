package com.hjht.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.coupon.api.entity.HomeSubjectEntity;

import java.util.Map;
import java.util.List;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
public interface HomeSubjectService extends IService<HomeSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @param  homeSubjectEntity
     * @return
     */
    Object saveHomeSubject(HomeSubjectEntity homeSubjectEntity);

    /**
     * 批量删除首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @param ids
     * @return
     */
    Object deleteBathHomeSubject(List<Long> ids);
}

