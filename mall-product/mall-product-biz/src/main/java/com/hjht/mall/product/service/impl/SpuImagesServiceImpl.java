package com.hjht.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.product.api.entity.SpuImagesEntity;
import com.hjht.mall.product.dao.SpuImagesDao;
import com.hjht.mall.product.service.SpuImagesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("spuImagesService")
public class SpuImagesServiceImpl extends ServiceImpl<SpuImagesDao, SpuImagesEntity> implements SpuImagesService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuImagesEntity> page = this.page(
                new Query<SpuImagesEntity>().getPage(params),
                new QueryWrapper<SpuImagesEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathSpuImages(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
     * 批量保存spu图片信息
     * @param id
     * @param images
     */
    @Override
    public void saveSpuImagesBath(Long id, List<String> images) {

    }

    /**
    * 保存
    * @param spuImagesEntity
    * @return
    */
    @Override
    public Object saveSpuImages(SpuImagesEntity spuImagesEntity) {
        baseMapper.insert(spuImagesEntity);
        return Boolean.TRUE;
    }

}