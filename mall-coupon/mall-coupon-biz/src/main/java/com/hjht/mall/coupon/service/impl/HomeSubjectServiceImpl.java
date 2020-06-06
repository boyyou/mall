package com.hjht.mall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.coupon.api.entity.HomeSubjectEntity;
import com.hjht.mall.coupon.dao.HomeSubjectDao;
import com.hjht.mall.coupon.service.HomeSubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("homeSubjectService")
public class HomeSubjectServiceImpl extends ServiceImpl<HomeSubjectDao, HomeSubjectEntity> implements HomeSubjectService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HomeSubjectEntity> page = this.page(
                new Query<HomeSubjectEntity>().getPage(params),
                new QueryWrapper<HomeSubjectEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathHomeSubject(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param homeSubjectEntity
    * @return
    */
    @Override
    public Object saveHomeSubject(HomeSubjectEntity homeSubjectEntity) {
        baseMapper.insert(homeSubjectEntity);
        return Boolean.TRUE;
    }

}