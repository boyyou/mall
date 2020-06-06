package com.hjht.mall.coupon.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.coupon.api.entity.CouponSpuRelationEntity;
import com.hjht.mall.coupon.service.CouponSpuRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 优惠券与产品关联
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/couponspurelation")
@Api(value = "优惠券与产品关联控制器}", tags = {"优惠券与产品关联控制器"})
public class CouponSpuRelationController {
    @Autowired
    private CouponSpuRelationService couponSpuRelationService;

    /**
     * 优惠券与产品关联列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "优惠券与产品关联列表查询", notes = "优惠券与产品关联列表查询")
    //@RequiresPermissions("coupon:couponspurelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponSpuRelationService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 优惠券与产品关联详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "优惠券与产品关联详情查询", notes = "优惠券与产品关联详情查询")
    //@RequiresPermissions("coupon:couponspurelation:info")
    public R info(@PathVariable("id") Long id){
		CouponSpuRelationEntity couponSpuRelation = couponSpuRelationService.getById(id);
        return R.ok(couponSpuRelation);
    }

    /**
     * 优惠券与产品关联保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "优惠券与产品关联保存", notes = "优惠券与产品关联保存")
    //@RequiresPermissions("coupon:couponspurelation:save")
    public R save(@RequestBody CouponSpuRelationEntity couponSpuRelation){
        Object result = couponSpuRelationService.saveCouponSpuRelation(couponSpuRelation);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 优惠券与产品关联修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "优惠券与产品关联修改", notes = "优惠券与产品关联修改")
    //@RequiresPermissions("coupon:couponspurelation:update")
    public R update(@RequestBody CouponSpuRelationEntity couponSpuRelation){
		couponSpuRelationService.updateById(couponSpuRelation);
        return R.ok();
    }

    /**
     * 优惠券与产品关联逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "优惠券与产品关联逻辑删除", notes = "优惠券与产品关联逻辑删除")
    //@RequiresPermissions("coupon:couponspurelation:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = couponSpuRelationService.deleteBathCouponSpuRelation(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
