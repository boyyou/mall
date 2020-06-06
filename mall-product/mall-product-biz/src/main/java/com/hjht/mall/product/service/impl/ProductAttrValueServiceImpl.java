package com.hjht.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.product.api.entity.ProductAttrValueEntity;
import com.hjht.mall.product.dao.ProductAttrValueDao;
import com.hjht.mall.product.service.ProductAttrValueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("productAttrValueService")
public class ProductAttrValueServiceImpl extends ServiceImpl<ProductAttrValueDao, ProductAttrValueEntity> implements ProductAttrValueService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductAttrValueEntity> page = this.page(
                new Query<ProductAttrValueEntity>().getPage(params),
                new QueryWrapper<ProductAttrValueEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathProductAttrValue(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param productAttrValueEntity
    * @return
    */
    @Override
    public Object saveProductAttrValue(ProductAttrValueEntity productAttrValueEntity) {
        baseMapper.insert(productAttrValueEntity);
        return Boolean.TRUE;
    }

}