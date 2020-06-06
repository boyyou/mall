package com.hjht.mall.order.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.order.api.entity.OrderSettingEntity;
import com.hjht.mall.order.service.OrderSettingService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 订单配置信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
@RestController
@RequestMapping("order/ordersetting")
@Api(value = "订单配置信息控制器}", tags = {"订单配置信息控制器"})
public class OrderSettingController {
    @Autowired
    private OrderSettingService orderSettingService;

    /**
     * 订单配置信息列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "订单配置信息列表查询", notes = "订单配置信息列表查询")
    //@RequiresPermissions("order:ordersetting:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderSettingService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 订单配置信息详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "订单配置信息详情查询", notes = "订单配置信息详情查询")
    //@RequiresPermissions("order:ordersetting:info")
    public R info(@PathVariable("id") Long id){
		OrderSettingEntity orderSetting = orderSettingService.getById(id);
        return R.ok(orderSetting);
    }

    /**
     * 订单配置信息保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "订单配置信息保存", notes = "订单配置信息保存")
    //@RequiresPermissions("order:ordersetting:save")
    public R save(@RequestBody OrderSettingEntity orderSetting){
        Object result = orderSettingService.saveOrderSetting(orderSetting);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 订单配置信息修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "订单配置信息修改", notes = "订单配置信息修改")
    //@RequiresPermissions("order:ordersetting:update")
    public R update(@RequestBody OrderSettingEntity orderSetting){
		orderSettingService.updateById(orderSetting);
        return R.ok();
    }

    /**
     * 订单配置信息逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "订单配置信息逻辑删除", notes = "订单配置信息逻辑删除")
    //@RequiresPermissions("order:ordersetting:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = orderSettingService.deleteBathOrderSetting(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
