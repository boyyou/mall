package com.hjht.mall.order.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.order.api.entity.PaymentInfoEntity;
import com.hjht.mall.order.service.PaymentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 支付信息表
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
@RestController
@RequestMapping("order/paymentinfo")
@Api(value = "支付信息表控制器}", tags = {"支付信息表控制器"})
public class PaymentInfoController {
    @Autowired
    private PaymentInfoService paymentInfoService;

    /**
     * 支付信息表列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "支付信息表列表查询", notes = "支付信息表列表查询")
    //@RequiresPermissions("order:paymentinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = paymentInfoService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 支付信息表详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "支付信息表详情查询", notes = "支付信息表详情查询")
    //@RequiresPermissions("order:paymentinfo:info")
    public R info(@PathVariable("id") Long id){
		PaymentInfoEntity paymentInfo = paymentInfoService.getById(id);
        return R.ok(paymentInfo);
    }

    /**
     * 支付信息表保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "支付信息表保存", notes = "支付信息表保存")
    //@RequiresPermissions("order:paymentinfo:save")
    public R save(@RequestBody PaymentInfoEntity paymentInfo){
        Object result = paymentInfoService.savePaymentInfo(paymentInfo);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 支付信息表修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "支付信息表修改", notes = "支付信息表修改")
    //@RequiresPermissions("order:paymentinfo:update")
    public R update(@RequestBody PaymentInfoEntity paymentInfo){
		paymentInfoService.updateById(paymentInfo);
        return R.ok();
    }

    /**
     * 支付信息表逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "支付信息表逻辑删除", notes = "支付信息表逻辑删除")
    //@RequiresPermissions("order:paymentinfo:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = paymentInfoService.deleteBathPaymentInfo(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
