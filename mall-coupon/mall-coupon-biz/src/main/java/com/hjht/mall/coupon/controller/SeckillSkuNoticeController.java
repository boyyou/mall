package com.hjht.mall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.coupon.api.entity.SeckillSkuNoticeEntity;
import com.hjht.mall.coupon.service.SeckillSkuNoticeService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 秒杀商品通知订阅
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/seckillskunotice")
@Api(value = "秒杀商品通知订阅控制器}", tags = {"秒杀商品通知订阅控制器"})
public class SeckillSkuNoticeController {
    @Autowired
    private SeckillSkuNoticeService seckillSkuNoticeService;

    /**
     * 秒杀商品通知订阅列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "秒杀商品通知订阅列表查询", notes = "秒杀商品通知订阅列表查询")
    //@RequiresPermissions("coupon:seckillskunotice:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = seckillSkuNoticeService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 秒杀商品通知订阅详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "秒杀商品通知订阅详情查询", notes = "秒杀商品通知订阅详情查询")
    //@RequiresPermissions("coupon:seckillskunotice:info")
    public R info(@PathVariable("id") Long id){
		SeckillSkuNoticeEntity seckillSkuNotice = seckillSkuNoticeService.getById(id);
        return R.ok(seckillSkuNotice);
    }

    /**
     * 秒杀商品通知订阅保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "秒杀商品通知订阅保存", notes = "秒杀商品通知订阅保存")
    //@RequiresPermissions("coupon:seckillskunotice:save")
    public R save(@RequestBody SeckillSkuNoticeEntity seckillSkuNotice){
        Object result = seckillSkuNoticeService.saveSeckillSkuNotice(seckillSkuNotice);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 秒杀商品通知订阅修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "秒杀商品通知订阅修改", notes = "秒杀商品通知订阅修改")
    //@RequiresPermissions("coupon:seckillskunotice:update")
    public R update(@RequestBody SeckillSkuNoticeEntity seckillSkuNotice){
		seckillSkuNoticeService.updateById(seckillSkuNotice);
        return R.ok();
    }

    /**
     * 秒杀商品通知订阅逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "秒杀商品通知订阅逻辑删除", notes = "秒杀商品通知订阅逻辑删除")
    //@RequiresPermissions("coupon:seckillskunotice:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = seckillSkuNoticeService.deleteBathSeckillSkuNotice(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
