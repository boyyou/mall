package com.hjht.mall.order.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.order.api.entity.OrderReturnReasonEntity;
import com.hjht.mall.order.service.OrderReturnReasonService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 退货原因
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
@RestController
@RequestMapping("order/orderreturnreason")
@Api(value = "退货原因控制器}", tags = {"退货原因控制器"})
public class OrderReturnReasonController {
    @Autowired
    private OrderReturnReasonService orderReturnReasonService;

    /**
     * 退货原因列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "退货原因列表查询", notes = "退货原因列表查询")
    //@RequiresPermissions("order:orderreturnreason:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderReturnReasonService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 退货原因详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "退货原因详情查询", notes = "退货原因详情查询")
    //@RequiresPermissions("order:orderreturnreason:info")
    public R info(@PathVariable("id") Long id){
		OrderReturnReasonEntity orderReturnReason = orderReturnReasonService.getById(id);
        return R.ok(orderReturnReason);
    }

    /**
     * 退货原因保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "退货原因保存", notes = "退货原因保存")
    //@RequiresPermissions("order:orderreturnreason:save")
    public R save(@RequestBody OrderReturnReasonEntity orderReturnReason){
        Object result = orderReturnReasonService.saveOrderReturnReason(orderReturnReason);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 退货原因修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "退货原因修改", notes = "退货原因修改")
    //@RequiresPermissions("order:orderreturnreason:update")
    public R update(@RequestBody OrderReturnReasonEntity orderReturnReason){
		orderReturnReasonService.updateById(orderReturnReason);
        return R.ok();
    }

    /**
     * 退货原因逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "退货原因逻辑删除", notes = "退货原因逻辑删除")
    //@RequiresPermissions("order:orderreturnreason:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = orderReturnReasonService.deleteBathOrderReturnReason(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
