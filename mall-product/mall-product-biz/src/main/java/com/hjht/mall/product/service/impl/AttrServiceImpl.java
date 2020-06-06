package com.hjht.mall.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.product.api.dto.AttrDTO;
import com.hjht.mall.product.api.dto.AttrGetDTO;
import com.hjht.mall.product.api.entity.AttrAttrgroupRelationEntity;
import com.hjht.mall.product.api.entity.AttrEntity;
import com.hjht.mall.product.api.entity.AttrGroupEntity;
import com.hjht.mall.product.api.entity.CategoryEntity;
import com.hjht.mall.product.api.vo.AttrVO;
import com.hjht.mall.product.dao.AttrAttrgroupRelationDao;
import com.hjht.mall.product.dao.AttrDao;
import com.hjht.mall.product.dao.AttrGroupDao;
import com.hjht.mall.product.dao.CategoryDao;
import com.hjht.mall.product.service.AttrService;
import com.hjht.mall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    private AttrAttrgroupRelationDao attrAttrgroupRelationDao;

    @Autowired
    private AttrGroupDao attrGroupDao;

    @Autowired
    private CategoryService categoryService;
    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public IPage<AttrVO> getPageByCatelogId(Page page, AttrGetDTO attrGetDTO) {
        IPage<AttrVO> pageByCatelogId = baseMapper.getPageByCatelogId(page, attrGetDTO);
        if (CollectionUtil.isNotEmpty(pageByCatelogId.getRecords())){
            List<CategoryEntity> parentPath = categoryService.getParentPath(pageByCatelogId.getRecords().get(0).getCatelogId());
            for (AttrVO attrVO : pageByCatelogId.getRecords()){
                attrVO.setParentPath(parentPath);
            }
        }
        return pageByCatelogId;
    }

    /**
     * 根据id查询属性详情1
     * @param attrId
     * @return
     */
    @Override
    public AttrVO getInfoById(Long attrId) {
        AttrVO infoById = baseMapper.getInfoById(attrId);
        if (infoById != null){
            List<CategoryEntity> parentPath = categoryService.getParentPath(infoById.getCatelogId());
            infoById.setParentPath(parentPath);
        }
        return infoById;
    }

    /**
     * 批量删除
     *
     * @param attrIds
     * @return
     */
    @Override
    public Object deleteBathAttr(List<Long> attrIds) {
        baseMapper.deleteBatchIds(attrIds);
        return Boolean.TRUE;
    }

    /**
     * 保存
     *
     * @param attrDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Object saveAttr(AttrDTO attrDTO) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtil.copyProperties(attrDTO, attrEntity);
        baseMapper.insert(attrEntity);
        if (attrDTO.getAttrGroupId() != null){
            AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrDTO.getAttrGroupId());
            if (!attrGroupEntity.getCatelogId().equals(attrDTO.getCatelogId())){
                throw new RuntimeException("属性分组与分类不符合!");
            }
            AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
            attrAttrgroupRelationEntity.setAttrGroupId(attrDTO.getAttrGroupId());
            attrAttrgroupRelationEntity.setAttrId(attrEntity.getAttrId());
            attrAttrgroupRelationDao.insert(attrAttrgroupRelationEntity);
        }
        return Boolean.TRUE;
    }

    /**
     * 修改属性信息
     * @param  attrDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Object updateAttr(AttrDTO attrDTO) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtil.copyProperties(attrDTO, attrEntity);
        baseMapper.updateById(attrEntity);
        if (attrDTO.getAttrGroupId() != null){
            AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrDTO.getAttrGroupId());
            if (!attrGroupEntity.getCatelogId().equals(attrDTO.getCatelogId())){
                throw new RuntimeException("属性分组与分类不符合!");
            }
            Integer integer = attrAttrgroupRelationDao.selectCount(Wrappers.<AttrAttrgroupRelationEntity>lambdaQuery().eq(AttrAttrgroupRelationEntity::getAttrId, attrDTO.getAttrId()));
            if (integer > 0){
                UpdateWrapper<AttrAttrgroupRelationEntity> updateWrapper = new UpdateWrapper();
                updateWrapper.eq("attr_id",attrDTO.getAttrId());
                AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
                attrAttrgroupRelationEntity.setAttrGroupId(attrDTO.getAttrGroupId());
                attrAttrgroupRelationDao.update(attrAttrgroupRelationEntity,updateWrapper);
            }else {
                AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
                attrAttrgroupRelationEntity.setAttrGroupId(attrDTO.getAttrGroupId());
                attrAttrgroupRelationEntity.setAttrId(attrDTO.getAttrId());
                attrAttrgroupRelationDao.insert(attrAttrgroupRelationEntity);
            }
        }
        return Boolean.TRUE;
    }
}
