package com.hjht.mall.order.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.order.api.entity.OrderItemEntity;
import com.hjht.mall.order.service.OrderItemService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 订单项信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
@RestController
@RequestMapping("order/orderitem")
@Api(value = "订单项信息控制器}", tags = {"订单项信息控制器"})
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    /**
     * 订单项信息列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "订单项信息列表查询", notes = "订单项信息列表查询")
    //@RequiresPermissions("order:orderitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderItemService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 订单项信息详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "订单项信息详情查询", notes = "订单项信息详情查询")
    //@RequiresPermissions("order:orderitem:info")
    public R info(@PathVariable("id") Long id){
		OrderItemEntity orderItem = orderItemService.getById(id);
        return R.ok(orderItem);
    }

    /**
     * 订单项信息保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "订单项信息保存", notes = "订单项信息保存")
    //@RequiresPermissions("order:orderitem:save")
    public R save(@RequestBody OrderItemEntity orderItem){
        Object result = orderItemService.saveOrderItem(orderItem);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 订单项信息修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "订单项信息修改", notes = "订单项信息修改")
    //@RequiresPermissions("order:orderitem:update")
    public R update(@RequestBody OrderItemEntity orderItem){
		orderItemService.updateById(orderItem);
        return R.ok();
    }

    /**
     * 订单项信息逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "订单项信息逻辑删除", notes = "订单项信息逻辑删除")
    //@RequiresPermissions("order:orderitem:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = orderItemService.deleteBathOrderItem(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
