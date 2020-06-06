package com.hjht.mall.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.dto.AttrDTO;
import com.hjht.mall.product.api.dto.AttrGetDTO;
import com.hjht.mall.product.api.dto.AttrGroupDTO;
import com.hjht.mall.product.api.dto.AttrGroupListDTO;
import com.hjht.mall.product.api.entity.AttrEntity;
import com.hjht.mall.product.api.entity.AttrGroupEntity;
import com.hjht.mall.product.api.vo.AttrWithAttrGroupVO;
import com.hjht.mall.product.service.AttrGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 属性分组
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/attrgroup")
@Api(value = "属性分组控制器}", tags = {"属性分组控制器"})
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    /**
     * 属性分组列表查询
     */
    /*@GetMapping("/list")
    @ApiOperation(value = "属性分组列表查询", notes = "属性分组列表查询")
    //@RequiresPermissions("product:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrGroupService.queryPage(params);
        return R.ok(page);
    }*/

    /**
     * 根据分类id属性分组列表查询
     */
    @GetMapping("/list/{categoryId}")
    @ApiOperation(value = "根据分类id属性分组列表查询", notes = "根据分类id属性分组列表查询")
    //@RequiresPermissions("product:attrgroup:list")
    public R<List<AttrGroupEntity>> listByCategoryId(Page page, @PathVariable("categoryId") Long categoryId, String attrGroupName){
        IPage<AttrGroupEntity> attrGroupEntityIPage = attrGroupService.listByCategoryId(page, categoryId,attrGroupName);
        return R.ok(attrGroupEntityIPage);
    }

    /**
     * 根据分组id查询分组下的所有属性
     */
    @GetMapping("/list/group")
    @ApiOperation(value = "根据分组id查询分组下的所有属性", notes = "根据分组id查询分组下的所有属性")
    //@RequiresPermissions("product:attrgroup:list")
    public R<List<AttrEntity>> listByGroupId(Page page,Long groupId){
        IPage<AttrEntity> attrGroupEntityIPage = attrGroupService.listByGroupId(page, groupId);
        return R.ok(attrGroupEntityIPage);
    }

    /**
     * 根据分组id和属性id删除分组和属性关联
     */
    @PostMapping("/delete/group/relation")
    @ApiOperation(value = "根据分组id和属性id删除分组和属性关联", notes = "根据分组id和属性id删除分组和属性关联")
    //@RequiresPermissions("product:attrgroup:list")
    public R deleteByGroupId(@Valid @RequestBody AttrGroupListDTO attrGroupDTO){
        attrGroupService.deleteByGroupId(attrGroupDTO.getList());
        return R.ok();
    }

    /**
     * 查询未被分组关联的属性
     * 必须是同一个分类下的属性
     * 必须未被分组关联
     */
    @GetMapping("/list/group/norelation")
    @ApiOperation(value = "查询未被分组关联的属性", notes = "查询未被分组关联的属性")
    //@RequiresPermissions("product:attrgroup:list")
    public R<List<AttrEntity>> listByGroupIdNoRelation(Page page,Long attrGroupId,String attrName){
        IPage<AttrEntity> attrEntityIPage = attrGroupService.listByGroupIdNoRelation(page,attrGroupId,attrName);
        return R.ok(attrEntityIPage);
    }


    /**
     * 根据分类id查询该分类下的全部属性分组及对应属性
     */
    @GetMapping("/list/group/attr")
    @ApiOperation(value = "根据分类id查询该分类下的全部属性分组及对应属性", notes = "根据分类id查询该分类下的全部属性分组及对应属性")
    //@RequiresPermissions("product:attrgroup:list")
    public R<List<AttrWithAttrGroupVO>> listByGroupWithAttr(Long catelogId){
        List<AttrWithAttrGroupVO> result = attrGroupService.listByGroupWithAttr(catelogId);
        return R.ok(result);
    }


    /**
     * 新增属性分组关联关系
     */
    @PostMapping("/save/relation")
    @ApiOperation(value = "新增属性分组关联关系", notes = "新增属性分组关联关系")
    //@RequiresPermissions("product:attrgroup:list")
    public R saveGroupRelation(@RequestBody AttrGroupDTO attrGroupDTO){
        attrGroupService.saveGroupRelation(attrGroupDTO);
        return R.ok();
    }

    /**
     * 属性分组详情查询
     */
    @GetMapping("/info/{attrGroupId}")
    @ApiOperation(value = "属性分组详情查询", notes = "属性分组详情查询")
    //@RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        return R.ok(attrGroup);
    }

    /**
     * 属性分组保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "属性分组保存", notes = "属性分组保存")
    //@RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
        Object result = attrGroupService.saveAttrGroup(attrGroup);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 属性分组修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "属性分组修改", notes = "属性分组修改")
    //@RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);
        return R.ok();
    }

    /**
     * 属性分组逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "属性分组逻辑删除", notes = "属性分组逻辑删除")
    //@RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds){
        Object result = attrGroupService.deleteBathAttrGroup(Arrays.asList(attrGroupIds));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
