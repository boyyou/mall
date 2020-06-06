package com.hjht.mall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.coupon.api.entity.SeckillSessionEntity;
import com.hjht.mall.coupon.service.SeckillSessionService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 秒杀活动场次
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/seckillsession")
@Api(value = "秒杀活动场次控制器}", tags = {"秒杀活动场次控制器"})
public class SeckillSessionController {
    @Autowired
    private SeckillSessionService seckillSessionService;

    /**
     * 秒杀活动场次列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "秒杀活动场次列表查询", notes = "秒杀活动场次列表查询")
    //@RequiresPermissions("coupon:seckillsession:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = seckillSessionService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 秒杀活动场次详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "秒杀活动场次详情查询", notes = "秒杀活动场次详情查询")
    //@RequiresPermissions("coupon:seckillsession:info")
    public R info(@PathVariable("id") Long id){
		SeckillSessionEntity seckillSession = seckillSessionService.getById(id);
        return R.ok(seckillSession);
    }

    /**
     * 秒杀活动场次保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "秒杀活动场次保存", notes = "秒杀活动场次保存")
    //@RequiresPermissions("coupon:seckillsession:save")
    public R save(@RequestBody SeckillSessionEntity seckillSession){
        Object result = seckillSessionService.saveSeckillSession(seckillSession);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 秒杀活动场次修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "秒杀活动场次修改", notes = "秒杀活动场次修改")
    //@RequiresPermissions("coupon:seckillsession:update")
    public R update(@RequestBody SeckillSessionEntity seckillSession){
		seckillSessionService.updateById(seckillSession);
        return R.ok();
    }

    /**
     * 秒杀活动场次逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "秒杀活动场次逻辑删除", notes = "秒杀活动场次逻辑删除")
    //@RequiresPermissions("coupon:seckillsession:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = seckillSessionService.deleteBathSeckillSession(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
