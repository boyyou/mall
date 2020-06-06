package com.hjht.mall.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.product.api.dto.AttrGroupDTO;
import com.hjht.mall.product.api.entity.AttrAttrgroupRelationEntity;
import com.hjht.mall.product.api.entity.AttrEntity;
import com.hjht.mall.product.api.entity.AttrGroupEntity;
import com.hjht.mall.product.api.vo.AttrWithAttrGroupVO;
import com.hjht.mall.product.dao.AttrAttrgroupRelationDao;
import com.hjht.mall.product.dao.AttrDao;
import com.hjht.mall.product.dao.AttrGroupDao;
import com.hjht.mall.product.service.AttrGroupService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    private AttrAttrgroupRelationDao attrAttrgroupRelationDao;

    @Autowired
    private AttrDao attrDao;

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );
        return new PageUtils(page);

    }

    /**
     * 根据分类id查询属性分组
     * @param page
     * @param categoryId
     * @return
     */
    @Override
    public IPage<AttrGroupEntity> listByCategoryId(Page page, Long categoryId, String attrGroupName) {
        QueryWrapper<AttrGroupEntity> queryWrapper = new QueryWrapper();
        if (categoryId != 0) {
            queryWrapper.eq("catelog_id",categoryId);
        }
        if (StringUtils.isNotEmpty(attrGroupName)){
            queryWrapper.like("attr_group_name",attrGroupName);
        }
        Page result = baseMapper.selectPage(page,queryWrapper);
        return result;
    }

    /**
    * 批量删除
    * @param attrGroupIds
    * @return
    */
    @Override
    public Object deleteBathAttrGroup(List<Long> attrGroupIds) {
        baseMapper.deleteBatchIds(attrGroupIds);
        return Boolean.TRUE;
    }

    /**
     * 根据分组id和属性id删除关联
     * @param list
     * @return
     */
    @Override
    public Object deleteByGroupId(List<AttrGroupDTO> list) {
        //attrAttrgroupRelationDao.delete(new UpdateWrapper<AttrAttrgroupRelationEntity>().eq("attr_group_id",attrGroupDTO.getAttrGroupId()).eq("attr_id",attrGroupDTO.getAttrId()));
        if (CollectionUtil.isNotEmpty(list)) {
            attrAttrgroupRelationDao.deleteBatchByIds(list);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据分组id查询该分组下的所有属性
     * @param page
     * @param categoryId
     * @return
     */
    @Override
    public IPage<AttrEntity> listByGroupId(Page page, Long categoryId) {
        List<AttrAttrgroupRelationEntity> attrAttrgroupRelationEntities = attrAttrgroupRelationDao.selectList(Wrappers.<AttrAttrgroupRelationEntity>lambdaQuery().eq(AttrAttrgroupRelationEntity::getAttrGroupId, categoryId));
        if (CollectionUtil.isNotEmpty(attrAttrgroupRelationEntities)){
            List<Long> collect = attrAttrgroupRelationEntities.stream().map(AttrAttrgroupRelationEntity::getAttrId).collect(Collectors.toList());
            Page<AttrEntity> page1 = attrDao.selectPage(page, new LambdaQueryWrapper<AttrEntity>().in(AttrEntity::getAttrId, collect));
            return page1;
        }
        return null;
    }

    /**
     * 查询未被关联的属性
     * @param attrGroupId
     * @return
     */
    @Override
    public IPage<AttrEntity> listByGroupIdNoRelation(Page page,Long attrGroupId,String attrName) {
        if (attrGroupId == null){
            throw new RuntimeException("系统繁忙，请稍后");
        }
        AttrGroupEntity attrGroupEntity = baseMapper.selectById(attrGroupId);
        //获取到该分组所属分类id
        Long catelogId = attrGroupEntity.getCatelogId();
        //根据分类id获取该分类下的所有分组
        List<AttrGroupEntity> attrGroupEntities = baseMapper.selectList(new LambdaQueryWrapper<AttrGroupEntity>().eq(AttrGroupEntity::getCatelogId, catelogId));
        List<Long> collect = attrGroupEntities.stream().map(AttrGroupEntity::getAttrGroupId).collect(Collectors.toList());
        //获取该分类下被关联的所有属性
        LambdaQueryWrapper<AttrAttrgroupRelationEntity> attrAttrgroupRelationEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<AttrAttrgroupRelationEntity> attrAttrgroupRelationEntities = null;
        if (CollectionUtil.isNotEmpty(collect)){
            attrAttrgroupRelationEntities = attrAttrgroupRelationDao.selectList(attrAttrgroupRelationEntityLambdaQueryWrapper.in(AttrAttrgroupRelationEntity::getAttrGroupId, collect));
        }
        List<Long> collect1 = null;
        if (CollectionUtil.isNotEmpty(attrAttrgroupRelationEntities)){
            collect1 = attrAttrgroupRelationEntities.stream().map(AttrAttrgroupRelationEntity::getAttrId).collect(Collectors.toList());
        }
        LambdaQueryWrapper<AttrEntity> attrEntityLambdaQueryWrapper = new LambdaQueryWrapper<AttrEntity>().eq(AttrEntity::getCatelogId, catelogId);
        if (CollectionUtil.isNotEmpty(collect1)){
            attrEntityLambdaQueryWrapper.notIn(AttrEntity::getAttrId, collect1);
        }
        if (StringUtils.isNotEmpty(attrName)){
            attrEntityLambdaQueryWrapper.like(AttrEntity::getAttrName,attrName);
        }
        Page<AttrEntity> page1 = attrDao.selectPage(page, attrEntityLambdaQueryWrapper);
        return page1;
    }

    /**
     * 新增属性关联关系
     * @param attrGroupDTO
     * @return
     */
    @Override
    public Object saveGroupRelation(AttrGroupDTO attrGroupDTO) {
        Integer integer1 = attrDao.selectCount(new LambdaQueryWrapper<AttrEntity>().eq(AttrEntity::getAttrId, attrGroupDTO.getAttrId()));
        if (integer1 == 0){
            throw new RuntimeException("该属性不存在");
        }
        Integer integer2 = baseMapper.selectCount(new LambdaQueryWrapper<AttrGroupEntity>().eq(AttrGroupEntity::getAttrGroupId, attrGroupDTO.getAttrGroupId()));
        if (integer2 == 0){
            throw  new RuntimeException("该属性分组不存在");
        }
        Integer integer = attrAttrgroupRelationDao.selectCount(new LambdaQueryWrapper<AttrAttrgroupRelationEntity>().eq(AttrAttrgroupRelationEntity::getAttrId, attrGroupDTO.getAttrId()));
        if (integer > 0){
            throw new RuntimeException("该属性已被其他分组关联");
        }
        AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
        attrAttrgroupRelationEntity.setAttrId(attrGroupDTO.getAttrId());
        attrAttrgroupRelationEntity.setAttrGroupId(attrGroupDTO.getAttrGroupId());
        attrAttrgroupRelationDao.insert(attrAttrgroupRelationEntity);
        return Boolean.TRUE;
    }

    /**
     * 查询分组及其下面所有属性
     * @param attrGroupId
     * @return
     */
    @Override
    public List<AttrWithAttrGroupVO> listByGroupWithAttr(Long attrGroupId) {
        //查询该分类下的所有属性分组
        List<AttrGroupEntity> attrGroupEntities = baseMapper.selectList(new LambdaQueryWrapper<AttrGroupEntity>().eq(AttrGroupEntity::getCatelogId, attrGroupId));
        if (CollectionUtil.isEmpty(attrGroupEntities)){
            return null;
        }
        List<AttrWithAttrGroupVO> collect2 = new ArrayList<>();
        for (AttrGroupEntity attrGroup : attrGroupEntities){
            AttrWithAttrGroupVO attrWithAttrGroupVO = new AttrWithAttrGroupVO();
            BeanUtil.copyProperties(attrGroup,attrWithAttrGroupVO);
            List<AttrAttrgroupRelationEntity> attrAttrgroupRelationEntities = attrAttrgroupRelationDao.selectList(Wrappers.<AttrAttrgroupRelationEntity>lambdaQuery().eq(AttrAttrgroupRelationEntity::getAttrGroupId, attrGroup.getAttrGroupId()));
            if (CollectionUtil.isEmpty(attrAttrgroupRelationEntities)){
                attrWithAttrGroupVO.setAttrs(null);
                continue;
            }
            List<Long> collect1 = attrAttrgroupRelationEntities.stream().map(AttrAttrgroupRelationEntity::getAttrId).collect(Collectors.toList());
            List<AttrEntity> attrEntities = attrDao.selectList(Wrappers.<AttrEntity>lambdaQuery().in(AttrEntity::getAttrId, collect1));
            attrWithAttrGroupVO.setAttrs(attrEntities);
            collect2.add(attrWithAttrGroupVO);
        }

        return collect2;
        /*List<AttrAttrgroupRelationEntity> attrAttrgroupRelationEntities = attrAttrgroupRelationDao.selectList(Wrappers.<AttrAttrgroupRelationEntity>lambdaQuery().in(AttrAttrgroupRelationEntity::getAttrGroupId, collect));
        if (CollectionUtil.isEmpty(attrAttrgroupRelationEntities)){
            return attrGroupEntities;
        }
        List<Long> collect1 = attrAttrgroupRelationEntities.stream().map(AttrAttrgroupRelationEntity::getAttrId).collect(Collectors.toList());
        List<AttrEntity> attrEntities = attrDao.selectList(Wrappers.<AttrEntity>lambdaQuery().in(AttrEntity::getAttrId, collect1));
        if (CollectionUtil.isEmpty(attrEntities)){
            return attrGroupEntities;
        }
        attrGroupEntities.stream().map(attrGroup->{

        })*/
    }

    /**
    * 保存
    * @param attrGroupEntity
    * @return
    */
    @Override
    public Object saveAttrGroup(AttrGroupEntity attrGroupEntity) {
        baseMapper.insert(attrGroupEntity);
        return Boolean.TRUE;
    }

}