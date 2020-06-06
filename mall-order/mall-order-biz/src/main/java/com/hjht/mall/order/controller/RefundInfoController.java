package com.hjht.mall.order.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.order.api.entity.RefundInfoEntity;
import com.hjht.mall.order.service.RefundInfoService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 退款信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
@RestController
@RequestMapping("order/refundinfo")
@Api(value = "退款信息控制器}", tags = {"退款信息控制器"})
public class RefundInfoController {
    @Autowired
    private RefundInfoService refundInfoService;

    /**
     * 退款信息列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "退款信息列表查询", notes = "退款信息列表查询")
    //@RequiresPermissions("order:refundinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = refundInfoService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 退款信息详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "退款信息详情查询", notes = "退款信息详情查询")
    //@RequiresPermissions("order:refundinfo:info")
    public R info(@PathVariable("id") Long id){
		RefundInfoEntity refundInfo = refundInfoService.getById(id);
        return R.ok(refundInfo);
    }

    /**
     * 退款信息保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "退款信息保存", notes = "退款信息保存")
    //@RequiresPermissions("order:refundinfo:save")
    public R save(@RequestBody RefundInfoEntity refundInfo){
        Object result = refundInfoService.saveRefundInfo(refundInfo);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 退款信息修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "退款信息修改", notes = "退款信息修改")
    //@RequiresPermissions("order:refundinfo:update")
    public R update(@RequestBody RefundInfoEntity refundInfo){
		refundInfoService.updateById(refundInfo);
        return R.ok();
    }

    /**
     * 退款信息逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "退款信息逻辑删除", notes = "退款信息逻辑删除")
    //@RequiresPermissions("order:refundinfo:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = refundInfoService.deleteBathRefundInfo(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
