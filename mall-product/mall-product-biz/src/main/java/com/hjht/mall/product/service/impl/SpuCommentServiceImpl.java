package com.hjht.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.product.api.entity.SpuCommentEntity;
import com.hjht.mall.product.dao.SpuCommentDao;
import com.hjht.mall.product.service.SpuCommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("spuCommentService")
public class SpuCommentServiceImpl extends ServiceImpl<SpuCommentDao, SpuCommentEntity> implements SpuCommentService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuCommentEntity> page = this.page(
                new Query<SpuCommentEntity>().getPage(params),
                new QueryWrapper<SpuCommentEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathSpuComment(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param spuCommentEntity
    * @return
    */
    @Override
    public Object saveSpuComment(SpuCommentEntity spuCommentEntity) {
        baseMapper.insert(spuCommentEntity);
        return Boolean.TRUE;
    }

}