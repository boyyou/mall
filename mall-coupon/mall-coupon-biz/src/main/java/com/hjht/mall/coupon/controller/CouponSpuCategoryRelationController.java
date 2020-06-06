package com.hjht.mall.coupon.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.coupon.api.entity.CouponSpuCategoryRelationEntity;
import com.hjht.mall.coupon.service.CouponSpuCategoryRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 优惠券分类关联
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/couponspucategoryrelation")
@Api(value = "优惠券分类关联控制器}", tags = {"优惠券分类关联控制器"})
public class CouponSpuCategoryRelationController {
    @Autowired
    private CouponSpuCategoryRelationService couponSpuCategoryRelationService;

    /**
     * 优惠券分类关联列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "优惠券分类关联列表查询", notes = "优惠券分类关联列表查询")
    //@RequiresPermissions("coupon:couponspucategoryrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponSpuCategoryRelationService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 优惠券分类关联详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "优惠券分类关联详情查询", notes = "优惠券分类关联详情查询")
    //@RequiresPermissions("coupon:couponspucategoryrelation:info")
    public R info(@PathVariable("id") Long id){
		CouponSpuCategoryRelationEntity couponSpuCategoryRelation = couponSpuCategoryRelationService.getById(id);
        return R.ok(couponSpuCategoryRelation);
    }

    /**
     * 优惠券分类关联保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "优惠券分类关联保存", notes = "优惠券分类关联保存")
    //@RequiresPermissions("coupon:couponspucategoryrelation:save")
    public R save(@RequestBody CouponSpuCategoryRelationEntity couponSpuCategoryRelation){
        Object result = couponSpuCategoryRelationService.saveCouponSpuCategoryRelation(couponSpuCategoryRelation);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 优惠券分类关联修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "优惠券分类关联修改", notes = "优惠券分类关联修改")
    //@RequiresPermissions("coupon:couponspucategoryrelation:update")
    public R update(@RequestBody CouponSpuCategoryRelationEntity couponSpuCategoryRelation){
		couponSpuCategoryRelationService.updateById(couponSpuCategoryRelation);
        return R.ok();
    }

    /**
     * 优惠券分类关联逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "优惠券分类关联逻辑删除", notes = "优惠券分类关联逻辑删除")
    //@RequiresPermissions("coupon:couponspucategoryrelation:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = couponSpuCategoryRelationService.deleteBathCouponSpuCategoryRelation(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
