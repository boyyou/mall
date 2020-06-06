package com.hjht.mall.order.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.order.api.entity.OrderEntity;
import com.hjht.mall.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 订单
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
@RestController
@RequestMapping("order/order")
@Api(value = "订单控制器}", tags = {"订单控制器"})
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 订单列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "订单列表查询", notes = "订单列表查询")
    //@RequiresPermissions("order:order:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 订单详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "订单详情查询", notes = "订单详情查询")
    //@RequiresPermissions("order:order:info")
    public R info(@PathVariable("id") Long id){
		OrderEntity order = orderService.getById(id);
        return R.ok(order);
    }

    /**
     * 订单保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "订单保存", notes = "订单保存")
    //@RequiresPermissions("order:order:save")
    public R save(@RequestBody OrderEntity order){
        Object result = orderService.saveOrder(order);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 订单修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "订单修改", notes = "订单修改")
    //@RequiresPermissions("order:order:update")
    public R update(@RequestBody OrderEntity order){
		orderService.updateById(order);
        return R.ok();
    }

    /**
     * 订单逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "订单逻辑删除", notes = "订单逻辑删除")
    //@RequiresPermissions("order:order:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = orderService.deleteBathOrder(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
