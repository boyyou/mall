package com.hjht.mall.product.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.entity.SkuInfoEntity;
import com.hjht.mall.product.service.SkuInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * sku信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/skuinfo")
@Api(value = "sku信息控制器}", tags = {"sku信息控制器"})
public class SkuInfoController {
    @Autowired
    private SkuInfoService skuInfoService;

    /**
     * sku信息列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "sku信息列表查询", notes = "sku信息列表查询")
    //@RequiresPermissions("product:skuinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = skuInfoService.queryPage(params);
        return R.ok(page);
    }


    /**
     * sku信息详情查询
     */
    @GetMapping("/info/{skuId}")
    @ApiOperation(value = "sku信息详情查询", notes = "sku信息详情查询")
    //@RequiresPermissions("product:skuinfo:info")
    public R info(@PathVariable("skuId") Long skuId){
		SkuInfoEntity skuInfo = skuInfoService.getById(skuId);
        return R.ok(skuInfo);
    }

    /**
     * sku信息保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "sku信息保存", notes = "sku信息保存")
    //@RequiresPermissions("product:skuinfo:save")
    public R save(@RequestBody SkuInfoEntity skuInfo){
        Object result = skuInfoService.saveSkuInfo(skuInfo);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * sku信息修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "sku信息修改", notes = "sku信息修改")
    //@RequiresPermissions("product:skuinfo:update")
    public R update(@RequestBody SkuInfoEntity skuInfo){
		skuInfoService.updateById(skuInfo);
        return R.ok();
    }

    /**
     * sku信息逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "sku信息逻辑删除", notes = "sku信息逻辑删除")
    //@RequiresPermissions("product:skuinfo:delete")
    public R delete(@RequestBody Long[] skuIds){
        Object result = skuInfoService.deleteBathSkuInfo(Arrays.asList(skuIds));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
