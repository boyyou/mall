package com.hjht.mall.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.dto.AttrDTO;
import com.hjht.mall.product.api.dto.AttrGetDTO;
import com.hjht.mall.product.api.entity.AttrEntity;
import com.hjht.mall.product.api.vo.AttrVO;
import com.hjht.mall.product.service.AttrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 商品属性
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/attr")
@Api(value = "商品属性控制器}", tags = {"商品属性控制器"})
public class AttrController {
    @Autowired
    private AttrService attrService;

    /**
     * 商品属性列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "商品属性列表查询", notes = "商品属性列表查询")
    //@RequiresPermissions("product:attr:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 商品属性详情查询
     */
    @GetMapping("/info/{attrId}")
    @ApiOperation(value = "商品属性详情查询", notes = "商品属性详情查询")
    //@RequiresPermissions("product:attr:info")
    public R<AttrVO> info(@PathVariable("attrId") Long attrId){
		AttrEntity attr = attrService.getInfoById(attrId);
        return R.ok(attr);
    }

    /**
     * 根据三级分类id查询属性列表
     */
    @GetMapping("/page")
    @ApiOperation(value = "根据三级分类id查询属性列表", notes = "根据三级分类id查询属性列表")
    //@RequiresPermissions("product:attr:info")
    public R<List<AttrEntity>> getPageByCatelogId(Page page, AttrGetDTO attrGetDTO){
        IPage<AttrVO> pageByCatelogId = attrService.getPageByCatelogId(page, attrGetDTO);
        return R.ok(pageByCatelogId);
    }

    /**
     * 商品属性保存
     * 基本属性是需要属于某一个属性分组的，比如京东是可以根据某个分类下面的属性分组点击其中的属性值查询，这个属性值就是基本属性
     * 属于一个spu有的，而销售属性关联到销售的价格库存等等，比如颜色，不归属于某一类分组
     */
    @PostMapping("/save")
    @ApiOperation(value = "商品属性保存", notes = "商品属性保存")
    //@RequiresPermissions("product:attr:save")
    public R save(@Valid @RequestBody AttrDTO attrDTO){
        Object result = attrService.saveAttr(attrDTO);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 商品属性修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "商品属性修改", notes = "商品属性修改")
    //@RequiresPermissions("product:attr:update")
    public R update(@RequestBody AttrDTO attrDTO){
		attrService.updateAttr(attrDTO);
        return R.ok();
    }

    /**
     * 商品属性逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "商品属性逻辑删除", notes = "商品属性逻辑删除")
    //@RequiresPermissions("product:attr:delete")
    public R delete(@RequestBody Long[] attrIds){
        Object result = attrService.deleteBathAttr(Arrays.asList(attrIds));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
