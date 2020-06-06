package com.hjht.mall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.coupon.api.entity.HomeSubjectSpuEntity;
import com.hjht.mall.coupon.service.HomeSubjectSpuService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 专题商品
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/homesubjectspu")
@Api(value = "专题商品控制器}", tags = {"专题商品控制器"})
public class HomeSubjectSpuController {
    @Autowired
    private HomeSubjectSpuService homeSubjectSpuService;

    /**
     * 专题商品列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "专题商品列表查询", notes = "专题商品列表查询")
    //@RequiresPermissions("coupon:homesubjectspu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = homeSubjectSpuService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 专题商品详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "专题商品详情查询", notes = "专题商品详情查询")
    //@RequiresPermissions("coupon:homesubjectspu:info")
    public R info(@PathVariable("id") Long id){
		HomeSubjectSpuEntity homeSubjectSpu = homeSubjectSpuService.getById(id);
        return R.ok(homeSubjectSpu);
    }

    /**
     * 专题商品保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "专题商品保存", notes = "专题商品保存")
    //@RequiresPermissions("coupon:homesubjectspu:save")
    public R save(@RequestBody HomeSubjectSpuEntity homeSubjectSpu){
        Object result = homeSubjectSpuService.saveHomeSubjectSpu(homeSubjectSpu);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 专题商品修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "专题商品修改", notes = "专题商品修改")
    //@RequiresPermissions("coupon:homesubjectspu:update")
    public R update(@RequestBody HomeSubjectSpuEntity homeSubjectSpu){
		homeSubjectSpuService.updateById(homeSubjectSpu);
        return R.ok();
    }

    /**
     * 专题商品逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "专题商品逻辑删除", notes = "专题商品逻辑删除")
    //@RequiresPermissions("coupon:homesubjectspu:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = homeSubjectSpuService.deleteBathHomeSubjectSpu(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
