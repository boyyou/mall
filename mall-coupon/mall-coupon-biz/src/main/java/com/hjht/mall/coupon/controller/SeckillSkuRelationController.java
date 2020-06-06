package com.hjht.mall.coupon.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.coupon.api.entity.SeckillSkuRelationEntity;
import com.hjht.mall.coupon.service.SeckillSkuRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 秒杀活动商品关联
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/seckillskurelation")
@Api(value = "秒杀活动商品关联控制器}", tags = {"秒杀活动商品关联控制器"})
public class SeckillSkuRelationController {
    @Autowired
    private SeckillSkuRelationService seckillSkuRelationService;

    /**
     * 秒杀活动商品关联列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "秒杀活动商品关联列表查询", notes = "秒杀活动商品关联列表查询")
    //@RequiresPermissions("coupon:seckillskurelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = seckillSkuRelationService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 秒杀活动商品关联详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "秒杀活动商品关联详情查询", notes = "秒杀活动商品关联详情查询")
    //@RequiresPermissions("coupon:seckillskurelation:info")
    public R info(@PathVariable("id") Long id){
		SeckillSkuRelationEntity seckillSkuRelation = seckillSkuRelationService.getById(id);
        return R.ok(seckillSkuRelation);
    }

    /**
     * 秒杀活动商品关联保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "秒杀活动商品关联保存", notes = "秒杀活动商品关联保存")
    //@RequiresPermissions("coupon:seckillskurelation:save")
    public R save(@RequestBody SeckillSkuRelationEntity seckillSkuRelation){
        Object result = seckillSkuRelationService.saveSeckillSkuRelation(seckillSkuRelation);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 秒杀活动商品关联修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "秒杀活动商品关联修改", notes = "秒杀活动商品关联修改")
    //@RequiresPermissions("coupon:seckillskurelation:update")
    public R update(@RequestBody SeckillSkuRelationEntity seckillSkuRelation){
		seckillSkuRelationService.updateById(seckillSkuRelation);
        return R.ok();
    }

    /**
     * 秒杀活动商品关联逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "秒杀活动商品关联逻辑删除", notes = "秒杀活动商品关联逻辑删除")
    //@RequiresPermissions("coupon:seckillskurelation:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = seckillSkuRelationService.deleteBathSeckillSkuRelation(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
