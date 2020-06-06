package com.hjht.mall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.coupon.api.entity.SkuLadderEntity;
import com.hjht.mall.coupon.service.SkuLadderService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 商品阶梯价格
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/skuladder")
@Api(value = "商品阶梯价格控制器}", tags = {"商品阶梯价格控制器"})
public class SkuLadderController {
    @Autowired
    private SkuLadderService skuLadderService;

    /**
     * 商品阶梯价格列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "商品阶梯价格列表查询", notes = "商品阶梯价格列表查询")
    //@RequiresPermissions("coupon:skuladder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = skuLadderService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 商品阶梯价格详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "商品阶梯价格详情查询", notes = "商品阶梯价格详情查询")
    //@RequiresPermissions("coupon:skuladder:info")
    public R info(@PathVariable("id") Long id){
		SkuLadderEntity skuLadder = skuLadderService.getById(id);
        return R.ok(skuLadder);
    }

    /**
     * 商品阶梯价格保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "商品阶梯价格保存", notes = "商品阶梯价格保存")
    //@RequiresPermissions("coupon:skuladder:save")
    public R save(@RequestBody SkuLadderEntity skuLadder){
        Object result = skuLadderService.saveSkuLadder(skuLadder);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 商品阶梯价格修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "商品阶梯价格修改", notes = "商品阶梯价格修改")
    //@RequiresPermissions("coupon:skuladder:update")
    public R update(@RequestBody SkuLadderEntity skuLadder){
		skuLadderService.updateById(skuLadder);
        return R.ok();
    }

    /**
     * 商品阶梯价格逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "商品阶梯价格逻辑删除", notes = "商品阶梯价格逻辑删除")
    //@RequiresPermissions("coupon:skuladder:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = skuLadderService.deleteBathSkuLadder(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
