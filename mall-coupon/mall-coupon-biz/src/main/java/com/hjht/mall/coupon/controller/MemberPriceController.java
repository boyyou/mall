package com.hjht.mall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.coupon.api.entity.MemberPriceEntity;
import com.hjht.mall.coupon.service.MemberPriceService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 商品会员价格
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/memberprice")
@Api(value = "商品会员价格控制器}", tags = {"商品会员价格控制器"})
public class MemberPriceController {
    @Autowired
    private MemberPriceService memberPriceService;

    /**
     * 商品会员价格列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "商品会员价格列表查询", notes = "商品会员价格列表查询")
    //@RequiresPermissions("coupon:memberprice:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberPriceService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 商品会员价格详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "商品会员价格详情查询", notes = "商品会员价格详情查询")
    //@RequiresPermissions("coupon:memberprice:info")
    public R info(@PathVariable("id") Long id){
		MemberPriceEntity memberPrice = memberPriceService.getById(id);
        return R.ok(memberPrice);
    }

    /**
     * 商品会员价格保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "商品会员价格保存", notes = "商品会员价格保存")
    //@RequiresPermissions("coupon:memberprice:save")
    public R save(@RequestBody MemberPriceEntity memberPrice){
        Object result = memberPriceService.saveMemberPrice(memberPrice);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 商品会员价格修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "商品会员价格修改", notes = "商品会员价格修改")
    //@RequiresPermissions("coupon:memberprice:update")
    public R update(@RequestBody MemberPriceEntity memberPrice){
		memberPriceService.updateById(memberPrice);
        return R.ok();
    }

    /**
     * 商品会员价格逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "商品会员价格逻辑删除", notes = "商品会员价格逻辑删除")
    //@RequiresPermissions("coupon:memberprice:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = memberPriceService.deleteBathMemberPrice(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
