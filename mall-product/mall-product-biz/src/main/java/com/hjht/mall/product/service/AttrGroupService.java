package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.dto.AttrGroupDTO;
import com.hjht.mall.product.api.entity.AttrEntity;
import com.hjht.mall.product.api.entity.AttrGroupEntity;
import com.hjht.mall.product.api.vo.AttrWithAttrGroupVO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    IPage<AttrGroupEntity> listByCategoryId(Page page, Long categoryId, String attrGroupName);

    /**
     * 保存属性分组
     * @param  attrGroupEntity
     * @return
     */
    Object saveAttrGroup(AttrGroupEntity attrGroupEntity);

    /**
     * 批量删除属性分组
     * @param attrGroupIds
     * @return
     */
    Object deleteBathAttrGroup(List<Long> attrGroupIds);

    /**
     * 根据分组id和属性id删除关联
     * @param list
     * @return
     */
    Object deleteByGroupId(List<AttrGroupDTO> list);

    IPage<AttrEntity> listByGroupId(Page page, Long categoryId);

    IPage<AttrEntity> listByGroupIdNoRelation(Page page,Long attrGroupId,String attrName);

    /**
     * 新增属性关联关系
     * @param attrGroupDTO
     * @return
     */
    Object saveGroupRelation(AttrGroupDTO attrGroupDTO);

    List<AttrWithAttrGroupVO> listByGroupWithAttr(Long attrGroupId);
}

