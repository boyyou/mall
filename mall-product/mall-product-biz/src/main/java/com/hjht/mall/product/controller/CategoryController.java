package com.hjht.mall.product.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.entity.CategoryEntity;
import com.hjht.mall.product.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 商品三级分类
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/category")
@Api(value = "商品三级分类控制器}", tags = {"商品三级分类控制器"})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 商品三级分类列表查询
     */
    @GetMapping("/list/tree")
    @ApiOperation(value = "商品三级分类列表查询", notes = "商品三级分类列表查询")
    //@RequiresPermissions("product:category:list")
    public R<List<CategoryEntity>> list(){
        List<CategoryEntity> list = categoryService.listCategory();
        return R.ok(list);
    }

    /**
     * 根据分类id查询所有父级
     */
    @GetMapping("/list/parent/{categoryId}")
    @ApiOperation(value = "根据分类id查询所有父级", notes = "根据分类id查询所有父级")
    //@RequiresPermissions("product:category:list")
    public R<List<CategoryEntity>> getParentPath(@PathVariable("categoryId") Long categoryId){
        List<CategoryEntity> parentPath = categoryService.getParentPath(categoryId);
        return R.ok(parentPath);
    }

    /**
     * 商品三级分类详情查询
     */
    @GetMapping("/info/{catId}")
    @ApiOperation(value = "商品三级分类详情查询", notes = "商品三级分类详情查询")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);
        return R.ok(category);
    }

    /**
     * 商品三级分类保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "商品三级分类保存", notes = "商品三级分类保存")
    //@RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
        Object o = categoryService.saveCategory(category);
        if (o instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(o.toString());
        }
    }

    /**
     * 商品三级分类修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "商品三级分类修改", notes = "商品三级分类修改")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);
        return R.ok();
    }

    /**
     * 商品三级分类修改子父级关系
     */
    @PostMapping("/update/relation")
    @ApiOperation(value = "商品三级分类修改", notes = "商品三级分类修改")
    //@RequiresPermissions("product:category:update")
    public R updateRelation(@RequestBody CategoryEntity category){
        categoryService.updateById(category);
        return R.ok();
    }

    /**
     * 商品三级分类逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "商品三级分类逻辑删除", notes = "商品三级分类逻辑删除")
    //@RequiresPermissions("product:category:delete")
    public R deleteBath(@RequestBody Long[] catIds){
        Object o = categoryService.deleteBath(Arrays.asList(catIds));
        if (o instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(o.toString());
        }
    }

}
