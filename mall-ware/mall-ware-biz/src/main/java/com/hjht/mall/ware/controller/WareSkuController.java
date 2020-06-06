package com.hjht.mall.ware.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.ware.api.entity.WareSkuEntity;
import com.hjht.mall.ware.service.WareSkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 商品库存
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
@RestController
@RequestMapping("ware/waresku")
@Api(value = "商品库存控制器}", tags = {"商品库存控制器"})
public class WareSkuController {
    @Autowired
    private WareSkuService wareSkuService;

    /**
     * 商品库存列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "商品库存列表查询", notes = "商品库存列表查询")
    //@RequiresPermissions("ware:waresku:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = wareSkuService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 商品库存详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "商品库存详情查询", notes = "商品库存详情查询")
    //@RequiresPermissions("ware:waresku:info")
    public R info(@PathVariable("id") Long id){
		WareSkuEntity wareSku = wareSkuService.getById(id);
        return R.ok(wareSku);
    }

    /**
     * 商品库存保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "商品库存保存", notes = "商品库存保存")
    //@RequiresPermissions("ware:waresku:save")
    public R save(@RequestBody WareSkuEntity wareSku){
        Object result = wareSkuService.saveWareSku(wareSku);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 商品库存修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "商品库存修改", notes = "商品库存修改")
    //@RequiresPermissions("ware:waresku:update")
    public R update(@RequestBody WareSkuEntity wareSku){
		wareSkuService.updateById(wareSku);
        return R.ok();
    }

    /**
     * 商品库存逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "商品库存逻辑删除", notes = "商品库存逻辑删除")
    //@RequiresPermissions("ware:waresku:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = wareSkuService.deleteBathWareSku(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
