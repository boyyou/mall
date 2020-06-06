package com.hjht.mall.coupon.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.coupon.api.entity.SpuBoundsEntity;
import com.hjht.mall.coupon.service.SpuBoundsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 商品spu积分设置
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/spubounds")
@Api(value = "商品spu积分设置控制器}", tags = {"商品spu积分设置控制器"})
public class SpuBoundsController {
    @Autowired
    private SpuBoundsService spuBoundsService;

    /**
     * 商品spu积分设置列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "商品spu积分设置列表查询", notes = "商品spu积分设置列表查询")
    //@RequiresPermissions("coupon:spubounds:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spuBoundsService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 商品spu积分设置详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "商品spu积分设置详情查询", notes = "商品spu积分设置详情查询")
    //@RequiresPermissions("coupon:spubounds:info")
    public R info(@PathVariable("id") Long id){
		SpuBoundsEntity spuBounds = spuBoundsService.getById(id);
        return R.ok(spuBounds);
    }

    /**
     * 商品spu积分设置保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "商品spu积分设置保存", notes = "商品spu积分设置保存")
    //@RequiresPermissions("coupon:spubounds:save")
    public R save(@RequestBody SpuBoundsEntity spuBounds){
        Object result = spuBoundsService.saveSpuBounds(spuBounds);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 商品spu积分设置修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "商品spu积分设置修改", notes = "商品spu积分设置修改")
    //@RequiresPermissions("coupon:spubounds:update")
    public R update(@RequestBody SpuBoundsEntity spuBounds){
		spuBoundsService.updateById(spuBounds);
        return R.ok();
    }

    /**
     * 商品spu积分设置逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "商品spu积分设置逻辑删除", notes = "商品spu积分设置逻辑删除")
    //@RequiresPermissions("coupon:spubounds:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = spuBoundsService.deleteBathSpuBounds(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
