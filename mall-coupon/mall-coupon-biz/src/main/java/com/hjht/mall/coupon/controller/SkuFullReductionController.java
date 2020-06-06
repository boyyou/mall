package com.hjht.mall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.coupon.api.entity.SkuFullReductionEntity;
import com.hjht.mall.coupon.service.SkuFullReductionService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 商品满减信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/skufullreduction")
@Api(value = "商品满减信息控制器}", tags = {"商品满减信息控制器"})
public class SkuFullReductionController {
    @Autowired
    private SkuFullReductionService skuFullReductionService;

    /**
     * 商品满减信息列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "商品满减信息列表查询", notes = "商品满减信息列表查询")
    //@RequiresPermissions("coupon:skufullreduction:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = skuFullReductionService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 商品满减信息详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "商品满减信息详情查询", notes = "商品满减信息详情查询")
    //@RequiresPermissions("coupon:skufullreduction:info")
    public R info(@PathVariable("id") Long id){
		SkuFullReductionEntity skuFullReduction = skuFullReductionService.getById(id);
        return R.ok(skuFullReduction);
    }

    /**
     * 商品满减信息保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "商品满减信息保存", notes = "商品满减信息保存")
    //@RequiresPermissions("coupon:skufullreduction:save")
    public R save(@RequestBody SkuFullReductionEntity skuFullReduction){
        Object result = skuFullReductionService.saveSkuFullReduction(skuFullReduction);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 商品满减信息修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "商品满减信息修改", notes = "商品满减信息修改")
    //@RequiresPermissions("coupon:skufullreduction:update")
    public R update(@RequestBody SkuFullReductionEntity skuFullReduction){
		skuFullReductionService.updateById(skuFullReduction);
        return R.ok();
    }

    /**
     * 商品满减信息逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "商品满减信息逻辑删除", notes = "商品满减信息逻辑删除")
    //@RequiresPermissions("coupon:skufullreduction:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = skuFullReductionService.deleteBathSkuFullReduction(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
