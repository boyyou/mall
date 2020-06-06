package com.hjht.mall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.coupon.api.entity.HomeAdvEntity;
import com.hjht.mall.coupon.service.HomeAdvService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 首页轮播广告
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/homeadv")
@Api(value = "首页轮播广告控制器}", tags = {"首页轮播广告控制器"})
public class HomeAdvController {
    @Autowired
    private HomeAdvService homeAdvService;

    /**
     * 首页轮播广告列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "首页轮播广告列表查询", notes = "首页轮播广告列表查询")
    //@RequiresPermissions("coupon:homeadv:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = homeAdvService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 首页轮播广告详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "首页轮播广告详情查询", notes = "首页轮播广告详情查询")
    //@RequiresPermissions("coupon:homeadv:info")
    public R info(@PathVariable("id") Long id){
		HomeAdvEntity homeAdv = homeAdvService.getById(id);
        return R.ok(homeAdv);
    }

    /**
     * 首页轮播广告保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "首页轮播广告保存", notes = "首页轮播广告保存")
    //@RequiresPermissions("coupon:homeadv:save")
    public R save(@RequestBody HomeAdvEntity homeAdv){
        Object result = homeAdvService.saveHomeAdv(homeAdv);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 首页轮播广告修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "首页轮播广告修改", notes = "首页轮播广告修改")
    //@RequiresPermissions("coupon:homeadv:update")
    public R update(@RequestBody HomeAdvEntity homeAdv){
		homeAdvService.updateById(homeAdv);
        return R.ok();
    }

    /**
     * 首页轮播广告逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "首页轮播广告逻辑删除", notes = "首页轮播广告逻辑删除")
    //@RequiresPermissions("coupon:homeadv:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = homeAdvService.deleteBathHomeAdv(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
