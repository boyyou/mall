package com.hjht.mall.coupon.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.coupon.api.entity.SeckillPromotionEntity;
import com.hjht.mall.coupon.service.SeckillPromotionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 秒杀活动
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/seckillpromotion")
@Api(value = "秒杀活动控制器}", tags = {"秒杀活动控制器"})
public class SeckillPromotionController {
    @Autowired
    private SeckillPromotionService seckillPromotionService;

    /**
     * 秒杀活动列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "秒杀活动列表查询", notes = "秒杀活动列表查询")
    //@RequiresPermissions("coupon:seckillpromotion:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = seckillPromotionService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 秒杀活动详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "秒杀活动详情查询", notes = "秒杀活动详情查询")
    //@RequiresPermissions("coupon:seckillpromotion:info")
    public R info(@PathVariable("id") Long id){
		SeckillPromotionEntity seckillPromotion = seckillPromotionService.getById(id);
        return R.ok(seckillPromotion);
    }

    /**
     * 秒杀活动保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "秒杀活动保存", notes = "秒杀活动保存")
    //@RequiresPermissions("coupon:seckillpromotion:save")
    public R save(@RequestBody SeckillPromotionEntity seckillPromotion){
        Object result = seckillPromotionService.saveSeckillPromotion(seckillPromotion);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 秒杀活动修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "秒杀活动修改", notes = "秒杀活动修改")
    //@RequiresPermissions("coupon:seckillpromotion:update")
    public R update(@RequestBody SeckillPromotionEntity seckillPromotion){
		seckillPromotionService.updateById(seckillPromotion);
        return R.ok();
    }

    /**
     * 秒杀活动逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "秒杀活动逻辑删除", notes = "秒杀活动逻辑删除")
    //@RequiresPermissions("coupon:seckillpromotion:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = seckillPromotionService.deleteBathSeckillPromotion(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
