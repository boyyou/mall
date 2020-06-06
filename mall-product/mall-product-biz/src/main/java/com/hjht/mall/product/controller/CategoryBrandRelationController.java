package com.hjht.mall.product.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.entity.BrandEntity;
import com.hjht.mall.product.api.entity.CategoryBrandRelationEntity;
import com.hjht.mall.product.api.vo.BrandSimpleVO;
import com.hjht.mall.product.service.CategoryBrandRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 品牌分类关联
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/categorybrandrelation")
@Api(value = "品牌分类关联控制器}", tags = {"品牌分类关联控制器"})
public class CategoryBrandRelationController {
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    /**
     * 品牌分类关联列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "品牌分类关联列表查询", notes = "品牌分类关联列表查询")
    //@RequiresPermissions("product:categorybrandrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryBrandRelationService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 根据分类查询该分类下所有的品牌
     */
    @GetMapping("/brand/list")
    @ApiOperation(value = "根据分类查询该分类下所有的品牌", notes = "根据分类查询该分类下所有的品牌")
    //@RequiresPermissions("product:categorybrandrelation:list")
    public R<List<BrandSimpleVO>> listBrand(Long catelogId){
        List<BrandEntity> brandEntities = categoryBrandRelationService.listBrand(catelogId);
        if (CollectionUtil.isEmpty(brandEntities)){
            return R.ok();
        }
        List<BrandSimpleVO> collect = brandEntities.stream().map(item -> {
            BrandSimpleVO brandSimpleVO = new BrandSimpleVO();
            brandSimpleVO.setBrandId(item.getBrandId());
            brandSimpleVO.setName(item.getName());
            return brandSimpleVO;
        }).collect(Collectors.toList());
        return R.ok(collect);
    }




    /**
     * 品牌分类关联详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "品牌分类关联详情查询", notes = "品牌分类关联详情查询")
    //@RequiresPermissions("product:categorybrandrelation:info")
    public R info(@PathVariable("id") Long id){
		CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);
        return R.ok(categoryBrandRelation);
    }

    /**
     * 品牌分类关联保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "品牌分类关联保存", notes = "品牌分类关联保存")
    //@RequiresPermissions("product:categorybrandrelation:save")
    public R save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
        Object result = categoryBrandRelationService.saveCategoryBrandRelation(categoryBrandRelation);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 品牌分类关联修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "品牌分类关联修改", notes = "品牌分类关联修改")
    //@RequiresPermissions("product:categorybrandrelation:update")
    public R update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
		categoryBrandRelationService.updateById(categoryBrandRelation);
        return R.ok();
    }

    /**
     * 品牌分类关联逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "品牌分类关联逻辑删除", notes = "品牌分类关联逻辑删除")
    //@RequiresPermissions("product:categorybrandrelation:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = categoryBrandRelationService.deleteBathCategoryBrandRelation(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
