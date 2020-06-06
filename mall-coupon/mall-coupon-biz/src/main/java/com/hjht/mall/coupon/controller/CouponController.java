package com.hjht.mall.coupon.controller;

import com.hjht.common.constant.RedisConstant;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.coupon.api.entity.CouponEntity;
import com.hjht.mall.coupon.service.CouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 优惠券信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/coupon")
@Api(value = "优惠券信息控制器}", tags = {"优惠券信息控制器"})
public class CouponController {
    @Autowired
    private CouponService couponService;

    @GetMapping("/list/cou")
    public R test(HttpServletRequest request){
        /*HttpSession session = request.getSession();
        Object ycl = session.getAttribute(RedisConstant.SESSION_NAME);*/
        return R.ok("这是一个测试数据feign!");
    }


    /**
     * 优惠券信息列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "优惠券信息列表查询", notes = "优惠券信息列表查询")
    //@RequiresPermissions("coupon:coupon:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 优惠券信息详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "优惠券信息详情查询", notes = "优惠券信息详情查询")
    //@RequiresPermissions("coupon:coupon:info")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);
        return R.ok(coupon);
    }

    /**
     * 优惠券信息保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "优惠券信息保存", notes = "优惠券信息保存")
    //@RequiresPermissions("coupon:coupon:save")
    public R save(@RequestBody CouponEntity coupon){
        Object result = couponService.saveCoupon(coupon);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 优惠券信息修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "优惠券信息修改", notes = "优惠券信息修改")
    //@RequiresPermissions("coupon:coupon:update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);
        return R.ok();
    }

    /**
     * 优惠券信息逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "优惠券信息逻辑删除", notes = "优惠券信息逻辑删除")
    //@RequiresPermissions("coupon:coupon:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = couponService.deleteBathCoupon(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
