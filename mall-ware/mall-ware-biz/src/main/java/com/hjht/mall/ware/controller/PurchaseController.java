package com.hjht.mall.ware.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.ware.api.entity.PurchaseEntity;
import com.hjht.mall.ware.service.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 采购信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
@RestController
@RequestMapping("ware/purchase")
@Api(value = "采购信息控制器}", tags = {"采购信息控制器"})
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    /**
     * 采购信息列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "采购信息列表查询", notes = "采购信息列表查询")
    //@RequiresPermissions("ware:purchase:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 采购信息详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "采购信息详情查询", notes = "采购信息详情查询")
    //@RequiresPermissions("ware:purchase:info")
    public R info(@PathVariable("id") Long id){
		PurchaseEntity purchase = purchaseService.getById(id);
        return R.ok(purchase);
    }

    /**
     * 采购信息保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "采购信息保存", notes = "采购信息保存")
    //@RequiresPermissions("ware:purchase:save")
    public R save(@RequestBody PurchaseEntity purchase){
        Object result = purchaseService.savePurchase(purchase);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 采购信息修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "采购信息修改", notes = "采购信息修改")
    //@RequiresPermissions("ware:purchase:update")
    public R update(@RequestBody PurchaseEntity purchase){
		purchaseService.updateById(purchase);
        return R.ok();
    }

    /**
     * 采购信息逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "采购信息逻辑删除", notes = "采购信息逻辑删除")
    //@RequiresPermissions("ware:purchase:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = purchaseService.deleteBathPurchase(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
