package com.hjht.mall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.coupon.api.entity.SpuBoundsEntity;
import com.hjht.mall.coupon.dao.SpuBoundsDao;
import com.hjht.mall.coupon.service.SpuBoundsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("spuBoundsService")
public class SpuBoundsServiceImpl extends ServiceImpl<SpuBoundsDao, SpuBoundsEntity> implements SpuBoundsService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuBoundsEntity> page = this.page(
                new Query<SpuBoundsEntity>().getPage(params),
                new QueryWrapper<SpuBoundsEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathSpuBounds(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param spuBoundsEntity
    * @return
    */
    @Override
    public Object saveSpuBounds(SpuBoundsEntity spuBoundsEntity) {
        baseMapper.insert(spuBoundsEntity);
        return Boolean.TRUE;
    }

}