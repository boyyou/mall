package com.hjht.mall.product.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.entity.SpuImagesEntity;
import com.hjht.mall.product.service.SpuImagesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * spu图片
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/spuimages")
@Api(value = "spu图片控制器}", tags = {"spu图片控制器"})
public class SpuImagesController {
    @Autowired
    private SpuImagesService spuImagesService;

    /**
     * spu图片列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "spu图片列表查询", notes = "spu图片列表查询")
    //@RequiresPermissions("product:spuimages:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spuImagesService.queryPage(params);
        return R.ok(page);
    }


    /**
     * spu图片详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "spu图片详情查询", notes = "spu图片详情查询")
    //@RequiresPermissions("product:spuimages:info")
    public R info(@PathVariable("id") Long id){
		SpuImagesEntity spuImages = spuImagesService.getById(id);
        return R.ok(spuImages);
    }

    /**
     * spu图片保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "spu图片保存", notes = "spu图片保存")
    //@RequiresPermissions("product:spuimages:save")
    public R save(@RequestBody SpuImagesEntity spuImages){
        Object result = spuImagesService.saveSpuImages(spuImages);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * spu图片修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "spu图片修改", notes = "spu图片修改")
    //@RequiresPermissions("product:spuimages:update")
    public R update(@RequestBody SpuImagesEntity spuImages){
		spuImagesService.updateById(spuImages);
        return R.ok();
    }

    /**
     * spu图片逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "spu图片逻辑删除", notes = "spu图片逻辑删除")
    //@RequiresPermissions("product:spuimages:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = spuImagesService.deleteBathSpuImages(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
