package com.hjht.mall.member.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.member.api.entity.GrowthChangeHistoryEntity;
import com.hjht.mall.member.service.GrowthChangeHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 成长值变化历史记录
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
@RestController
@RequestMapping("member/growthchangehistory")
@Api(value = "成长值变化历史记录控制器}", tags = {"成长值变化历史记录控制器"})
public class GrowthChangeHistoryController {
    @Autowired
    private GrowthChangeHistoryService growthChangeHistoryService;

    /**
     * 成长值变化历史记录列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "成长值变化历史记录列表查询", notes = "成长值变化历史记录列表查询")
    //@RequiresPermissions("member:growthchangehistory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = growthChangeHistoryService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 成长值变化历史记录详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "成长值变化历史记录详情查询", notes = "成长值变化历史记录详情查询")
    //@RequiresPermissions("member:growthchangehistory:info")
    public R info(@PathVariable("id") Long id){
		GrowthChangeHistoryEntity growthChangeHistory = growthChangeHistoryService.getById(id);
        return R.ok(growthChangeHistory);
    }

    /**
     * 成长值变化历史记录保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "成长值变化历史记录保存", notes = "成长值变化历史记录保存")
    //@RequiresPermissions("member:growthchangehistory:save")
    public R save(@RequestBody GrowthChangeHistoryEntity growthChangeHistory){
        Object result = growthChangeHistoryService.saveGrowthChangeHistory(growthChangeHistory);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 成长值变化历史记录修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "成长值变化历史记录修改", notes = "成长值变化历史记录修改")
    //@RequiresPermissions("member:growthchangehistory:update")
    public R update(@RequestBody GrowthChangeHistoryEntity growthChangeHistory){
		growthChangeHistoryService.updateById(growthChangeHistory);
        return R.ok();
    }

    /**
     * 成长值变化历史记录逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "成长值变化历史记录逻辑删除", notes = "成长值变化历史记录逻辑删除")
    //@RequiresPermissions("member:growthchangehistory:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = growthChangeHistoryService.deleteBathGrowthChangeHistory(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
