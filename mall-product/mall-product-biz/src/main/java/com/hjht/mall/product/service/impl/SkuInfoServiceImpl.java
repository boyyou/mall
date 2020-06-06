package com.hjht.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.product.api.entity.SkuInfoEntity;
import com.hjht.mall.product.dao.SkuInfoDao;
import com.hjht.mall.product.service.SkuInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoDao, SkuInfoEntity> implements SkuInfoService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                new QueryWrapper<SkuInfoEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param skuIds
    * @return
    */
    @Override
    public Object deleteBathSkuInfo(List<Long> skuIds) {
        baseMapper.deleteBatchIds(skuIds);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param skuInfoEntity
    * @return
    */
    @Override
    public Object saveSkuInfo(SkuInfoEntity skuInfoEntity) {
        baseMapper.insert(skuInfoEntity);
        return Boolean.TRUE;
    }

}