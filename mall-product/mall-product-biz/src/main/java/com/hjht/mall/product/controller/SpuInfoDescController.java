package com.hjht.mall.product.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.entity.SpuInfoDescEntity;
import com.hjht.mall.product.service.SpuInfoDescService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * spu信息介绍
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/spuinfodesc")
@Api(value = "spu信息介绍控制器}", tags = {"spu信息介绍控制器"})
public class SpuInfoDescController {
    @Autowired
    private SpuInfoDescService spuInfoDescService;

    /**
     * spu信息介绍列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "spu信息介绍列表查询", notes = "spu信息介绍列表查询")
    //@RequiresPermissions("product:spuinfodesc:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spuInfoDescService.queryPage(params);
        return R.ok(page);
    }


    /**
     * spu信息介绍详情查询
     */
    @GetMapping("/info/{spuId}")
    @ApiOperation(value = "spu信息介绍详情查询", notes = "spu信息介绍详情查询")
    //@RequiresPermissions("product:spuinfodesc:info")
    public R info(@PathVariable("spuId") Long spuId){
		SpuInfoDescEntity spuInfoDesc = spuInfoDescService.getById(spuId);
        return R.ok(spuInfoDesc);
    }

    /**
     * spu信息介绍保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "spu信息介绍保存", notes = "spu信息介绍保存")
    //@RequiresPermissions("product:spuinfodesc:save")
    public R save(@RequestBody SpuInfoDescEntity spuInfoDesc){
        Object result = spuInfoDescService.saveSpuInfoDesc(spuInfoDesc);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * spu信息介绍修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "spu信息介绍修改", notes = "spu信息介绍修改")
    //@RequiresPermissions("product:spuinfodesc:update")
    public R update(@RequestBody SpuInfoDescEntity spuInfoDesc){
		spuInfoDescService.updateById(spuInfoDesc);
        return R.ok();
    }

    /**
     * spu信息介绍逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "spu信息介绍逻辑删除", notes = "spu信息介绍逻辑删除")
    //@RequiresPermissions("product:spuinfodesc:delete")
    public R delete(@RequestBody Long[] spuIds){
        Object result = spuInfoDescService.deleteBathSpuInfoDesc(Arrays.asList(spuIds));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
