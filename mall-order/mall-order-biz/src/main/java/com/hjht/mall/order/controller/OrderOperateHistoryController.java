package com.hjht.mall.order.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.order.api.entity.OrderOperateHistoryEntity;
import com.hjht.mall.order.service.OrderOperateHistoryService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 订单操作历史记录
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
@RestController
@RequestMapping("order/orderoperatehistory")
@Api(value = "订单操作历史记录控制器}", tags = {"订单操作历史记录控制器"})
public class OrderOperateHistoryController {
    @Autowired
    private OrderOperateHistoryService orderOperateHistoryService;

    /**
     * 订单操作历史记录列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "订单操作历史记录列表查询", notes = "订单操作历史记录列表查询")
    //@RequiresPermissions("order:orderoperatehistory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderOperateHistoryService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 订单操作历史记录详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "订单操作历史记录详情查询", notes = "订单操作历史记录详情查询")
    //@RequiresPermissions("order:orderoperatehistory:info")
    public R info(@PathVariable("id") Long id){
		OrderOperateHistoryEntity orderOperateHistory = orderOperateHistoryService.getById(id);
        return R.ok(orderOperateHistory);
    }

    /**
     * 订单操作历史记录保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "订单操作历史记录保存", notes = "订单操作历史记录保存")
    //@RequiresPermissions("order:orderoperatehistory:save")
    public R save(@RequestBody OrderOperateHistoryEntity orderOperateHistory){
        Object result = orderOperateHistoryService.saveOrderOperateHistory(orderOperateHistory);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 订单操作历史记录修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "订单操作历史记录修改", notes = "订单操作历史记录修改")
    //@RequiresPermissions("order:orderoperatehistory:update")
    public R update(@RequestBody OrderOperateHistoryEntity orderOperateHistory){
		orderOperateHistoryService.updateById(orderOperateHistory);
        return R.ok();
    }

    /**
     * 订单操作历史记录逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "订单操作历史记录逻辑删除", notes = "订单操作历史记录逻辑删除")
    //@RequiresPermissions("order:orderoperatehistory:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = orderOperateHistoryService.deleteBathOrderOperateHistory(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
