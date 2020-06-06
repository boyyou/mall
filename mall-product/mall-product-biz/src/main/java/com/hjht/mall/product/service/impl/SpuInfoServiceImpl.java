package com.hjht.mall.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.product.api.entity.SpuInfoDescEntity;
import com.hjht.mall.product.api.entity.SpuInfoEntity;
import com.hjht.mall.product.api.vo.SpuSaveVo;
import com.hjht.mall.product.dao.SpuInfoDao;
import com.hjht.mall.product.service.SpuImagesService;
import com.hjht.mall.product.service.SpuInfoDescService;
import com.hjht.mall.product.service.SpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {


    @Autowired
    private SpuInfoDescService spuInfoDescService;

    @Autowired
    private SpuImagesService spuImagesService;
    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<SpuInfoEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathSpuInfo(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param spuSaveVo
    * @return
    */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Object saveSpuInfo(SpuSaveVo spuSaveVo) {
        //1.保存spu基本信息
        SpuInfoEntity spuInfoEntity = new SpuInfoEntity();
        BeanUtil.copyProperties(spuSaveVo,spuInfoEntity);
        baseMapper.insert(spuInfoEntity);
        //2.保存spu描述长图，参考京东和苏宁，同一spu的商品他们的详细描述都是几张长图
        List<String> decript = spuSaveVo.getDecript();
        SpuInfoDescEntity spuInfoDescEntity = new SpuInfoDescEntity();
        spuInfoDescEntity.setSpuId(spuInfoEntity.getId());
        spuInfoDescEntity.setDecript(String.join(",",decript));
        spuInfoDescService.save(spuInfoDescEntity);
        //3.保存spu图集，这些图集是整个spu的图集用于设置sku的图集从这些图集中选择
        spuImagesService.saveSpuImagesBath(spuInfoEntity.getId(),spuSaveVo.getImages());
        return Boolean.TRUE;
    }

}