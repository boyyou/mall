package com.hjht.mall.product.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.entity.SkuImagesEntity;
import com.hjht.mall.product.service.SkuImagesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * sku图片
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/skuimages")
@Api(value = "sku图片控制器}", tags = {"sku图片控制器"})
public class SkuImagesController {
    @Autowired
    private SkuImagesService skuImagesService;

    /**
     * sku图片列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "sku图片列表查询", notes = "sku图片列表查询")
    //@RequiresPermissions("product:skuimages:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = skuImagesService.queryPage(params);
        return R.ok(page);
    }


    /**
     * sku图片详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "sku图片详情查询", notes = "sku图片详情查询")
    //@RequiresPermissions("product:skuimages:info")
    public R info(@PathVariable("id") Long id){
		SkuImagesEntity skuImages = skuImagesService.getById(id);
        return R.ok(skuImages);
    }

    /**
     * sku图片保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "sku图片保存", notes = "sku图片保存")
    //@RequiresPermissions("product:skuimages:save")
    public R save(@RequestBody SkuImagesEntity skuImages){
        Object result = skuImagesService.saveSkuImages(skuImages);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * sku图片修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "sku图片修改", notes = "sku图片修改")
    //@RequiresPermissions("product:skuimages:update")
    public R update(@RequestBody SkuImagesEntity skuImages){
		skuImagesService.updateById(skuImages);
        return R.ok();
    }

    /**
     * sku图片逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "sku图片逻辑删除", notes = "sku图片逻辑删除")
    //@RequiresPermissions("product:skuimages:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = skuImagesService.deleteBathSkuImages(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
