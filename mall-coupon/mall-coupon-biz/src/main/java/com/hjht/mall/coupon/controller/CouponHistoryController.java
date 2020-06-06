package com.hjht.mall.coupon.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.coupon.api.entity.CouponHistoryEntity;
import com.hjht.mall.coupon.service.CouponHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 优惠券领取历史记录
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/couponhistory")
@Api(value = "优惠券领取历史记录控制器}", tags = {"优惠券领取历史记录控制器"})
public class CouponHistoryController {
    @Autowired
    private CouponHistoryService couponHistoryService;

    /**
     * 优惠券领取历史记录列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "优惠券领取历史记录列表查询", notes = "优惠券领取历史记录列表查询")
    //@RequiresPermissions("coupon:couponhistory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponHistoryService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 优惠券领取历史记录详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "优惠券领取历史记录详情查询", notes = "优惠券领取历史记录详情查询")
    //@RequiresPermissions("coupon:couponhistory:info")
    public R info(@PathVariable("id") Long id){
		CouponHistoryEntity couponHistory = couponHistoryService.getById(id);
        return R.ok(couponHistory);
    }

    /**
     * 优惠券领取历史记录保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "优惠券领取历史记录保存", notes = "优惠券领取历史记录保存")
    //@RequiresPermissions("coupon:couponhistory:save")
    public R save(@RequestBody CouponHistoryEntity couponHistory){
        Object result = couponHistoryService.saveCouponHistory(couponHistory);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 优惠券领取历史记录修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "优惠券领取历史记录修改", notes = "优惠券领取历史记录修改")
    //@RequiresPermissions("coupon:couponhistory:update")
    public R update(@RequestBody CouponHistoryEntity couponHistory){
		couponHistoryService.updateById(couponHistory);
        return R.ok();
    }

    /**
     * 优惠券领取历史记录逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "优惠券领取历史记录逻辑删除", notes = "优惠券领取历史记录逻辑删除")
    //@RequiresPermissions("coupon:couponhistory:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = couponHistoryService.deleteBathCouponHistory(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
