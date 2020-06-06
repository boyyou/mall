package com.hjht.mall.ware.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.ware.api.entity.PurchaseDetailEntity;
import com.hjht.mall.ware.service.PurchaseDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
@RestController
@RequestMapping("ware/purchasedetail")
@Api(value = "控制器}", tags = {"控制器"})
public class PurchaseDetailController {
    @Autowired
    private PurchaseDetailService purchaseDetailService;

    /**
     * 列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "列表查询", notes = "列表查询")
    //@RequiresPermissions("ware:purchasedetail:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseDetailService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "详情查询", notes = "详情查询")
    //@RequiresPermissions("ware:purchasedetail:info")
    public R info(@PathVariable("id") Long id){
		PurchaseDetailEntity purchaseDetail = purchaseDetailService.getById(id);
        return R.ok(purchaseDetail);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存", notes = "保存")
    //@RequiresPermissions("ware:purchasedetail:save")
    public R save(@RequestBody PurchaseDetailEntity purchaseDetail){
        Object result = purchaseDetailService.savePurchaseDetail(purchaseDetail);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改", notes = "修改")
    //@RequiresPermissions("ware:purchasedetail:update")
    public R update(@RequestBody PurchaseDetailEntity purchaseDetail){
		purchaseDetailService.updateById(purchaseDetail);
        return R.ok();
    }

    /**
     * 逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "逻辑删除", notes = "逻辑删除")
    //@RequiresPermissions("ware:purchasedetail:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = purchaseDetailService.deleteBathPurchaseDetail(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
