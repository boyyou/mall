package com.hjht.mall.product.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.entity.SkuSaleAttrValueEntity;
import com.hjht.mall.product.service.SkuSaleAttrValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * sku销售属性&值
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/skusaleattrvalue")
@Api(value = "sku销售属性&值控制器}", tags = {"sku销售属性&值控制器"})
public class SkuSaleAttrValueController {
    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;

    /**
     * sku销售属性&值列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "sku销售属性&值列表查询", notes = "sku销售属性&值列表查询")
    //@RequiresPermissions("product:skusaleattrvalue:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = skuSaleAttrValueService.queryPage(params);
        return R.ok(page);
    }


    /**
     * sku销售属性&值详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "sku销售属性&值详情查询", notes = "sku销售属性&值详情查询")
    //@RequiresPermissions("product:skusaleattrvalue:info")
    public R info(@PathVariable("id") Long id){
		SkuSaleAttrValueEntity skuSaleAttrValue = skuSaleAttrValueService.getById(id);
        return R.ok(skuSaleAttrValue);
    }

    /**
     * sku销售属性&值保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "sku销售属性&值保存", notes = "sku销售属性&值保存")
    //@RequiresPermissions("product:skusaleattrvalue:save")
    public R save(@RequestBody SkuSaleAttrValueEntity skuSaleAttrValue){
        Object result = skuSaleAttrValueService.saveSkuSaleAttrValue(skuSaleAttrValue);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * sku销售属性&值修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "sku销售属性&值修改", notes = "sku销售属性&值修改")
    //@RequiresPermissions("product:skusaleattrvalue:update")
    public R update(@RequestBody SkuSaleAttrValueEntity skuSaleAttrValue){
		skuSaleAttrValueService.updateById(skuSaleAttrValue);
        return R.ok();
    }

    /**
     * sku销售属性&值逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "sku销售属性&值逻辑删除", notes = "sku销售属性&值逻辑删除")
    //@RequiresPermissions("product:skusaleattrvalue:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = skuSaleAttrValueService.deleteBathSkuSaleAttrValue(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
