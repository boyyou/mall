package com.hjht.mall.order.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.order.api.entity.OrderReturnApplyEntity;
import com.hjht.mall.order.service.OrderReturnApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 订单退货申请
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
@RestController
@RequestMapping("order/orderreturnapply")
@Api(value = "订单退货申请控制器}", tags = {"订单退货申请控制器"})
public class OrderReturnApplyController {
    @Autowired
    private OrderReturnApplyService orderReturnApplyService;

    /**
     * 订单退货申请列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "订单退货申请列表查询", notes = "订单退货申请列表查询")
    //@RequiresPermissions("order:orderreturnapply:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderReturnApplyService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 订单退货申请详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "订单退货申请详情查询", notes = "订单退货申请详情查询")
    //@RequiresPermissions("order:orderreturnapply:info")
    public R info(@PathVariable("id") Long id){
		OrderReturnApplyEntity orderReturnApply = orderReturnApplyService.getById(id);
        return R.ok(orderReturnApply);
    }

    /**
     * 订单退货申请保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "订单退货申请保存", notes = "订单退货申请保存")
    //@RequiresPermissions("order:orderreturnapply:save")
    public R save(@RequestBody OrderReturnApplyEntity orderReturnApply){
        Object result = orderReturnApplyService.saveOrderReturnApply(orderReturnApply);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 订单退货申请修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "订单退货申请修改", notes = "订单退货申请修改")
    //@RequiresPermissions("order:orderreturnapply:update")
    public R update(@RequestBody OrderReturnApplyEntity orderReturnApply){
		orderReturnApplyService.updateById(orderReturnApply);
        return R.ok();
    }

    /**
     * 订单退货申请逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "订单退货申请逻辑删除", notes = "订单退货申请逻辑删除")
    //@RequiresPermissions("order:orderreturnapply:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = orderReturnApplyService.deleteBathOrderReturnApply(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
