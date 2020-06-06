package com.hjht.mall.member.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.member.api.entity.IntegrationChangeHistoryEntity;
import com.hjht.mall.member.service.IntegrationChangeHistoryService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 积分变化历史记录
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
@RestController
@RequestMapping("member/integrationchangehistory")
@Api(value = "积分变化历史记录控制器}", tags = {"积分变化历史记录控制器"})
public class IntegrationChangeHistoryController {
    @Autowired
    private IntegrationChangeHistoryService integrationChangeHistoryService;

    /**
     * 积分变化历史记录列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "积分变化历史记录列表查询", notes = "积分变化历史记录列表查询")
    //@RequiresPermissions("member:integrationchangehistory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = integrationChangeHistoryService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 积分变化历史记录详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "积分变化历史记录详情查询", notes = "积分变化历史记录详情查询")
    //@RequiresPermissions("member:integrationchangehistory:info")
    public R info(@PathVariable("id") Long id){
		IntegrationChangeHistoryEntity integrationChangeHistory = integrationChangeHistoryService.getById(id);
        return R.ok(integrationChangeHistory);
    }

    /**
     * 积分变化历史记录保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "积分变化历史记录保存", notes = "积分变化历史记录保存")
    //@RequiresPermissions("member:integrationchangehistory:save")
    public R save(@RequestBody IntegrationChangeHistoryEntity integrationChangeHistory){
        Object result = integrationChangeHistoryService.saveIntegrationChangeHistory(integrationChangeHistory);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 积分变化历史记录修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "积分变化历史记录修改", notes = "积分变化历史记录修改")
    //@RequiresPermissions("member:integrationchangehistory:update")
    public R update(@RequestBody IntegrationChangeHistoryEntity integrationChangeHistory){
		integrationChangeHistoryService.updateById(integrationChangeHistory);
        return R.ok();
    }

    /**
     * 积分变化历史记录逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "积分变化历史记录逻辑删除", notes = "积分变化历史记录逻辑删除")
    //@RequiresPermissions("member:integrationchangehistory:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = integrationChangeHistoryService.deleteBathIntegrationChangeHistory(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
