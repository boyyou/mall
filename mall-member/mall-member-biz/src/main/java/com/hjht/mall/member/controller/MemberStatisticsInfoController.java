package com.hjht.mall.member.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.member.api.entity.MemberStatisticsInfoEntity;
import com.hjht.mall.member.service.MemberStatisticsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 会员统计信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:25
 */
@RestController
@RequestMapping("member/memberstatisticsinfo")
@Api(value = "会员统计信息控制器}", tags = {"会员统计信息控制器"})
public class MemberStatisticsInfoController {
    @Autowired
    private MemberStatisticsInfoService memberStatisticsInfoService;

    /**
     * 会员统计信息列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "会员统计信息列表查询", notes = "会员统计信息列表查询")
    //@RequiresPermissions("member:memberstatisticsinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberStatisticsInfoService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 会员统计信息详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "会员统计信息详情查询", notes = "会员统计信息详情查询")
    //@RequiresPermissions("member:memberstatisticsinfo:info")
    public R info(@PathVariable("id") Long id){
		MemberStatisticsInfoEntity memberStatisticsInfo = memberStatisticsInfoService.getById(id);
        return R.ok(memberStatisticsInfo);
    }

    /**
     * 会员统计信息保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "会员统计信息保存", notes = "会员统计信息保存")
    //@RequiresPermissions("member:memberstatisticsinfo:save")
    public R save(@RequestBody MemberStatisticsInfoEntity memberStatisticsInfo){
        Object result = memberStatisticsInfoService.saveMemberStatisticsInfo(memberStatisticsInfo);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 会员统计信息修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "会员统计信息修改", notes = "会员统计信息修改")
    //@RequiresPermissions("member:memberstatisticsinfo:update")
    public R update(@RequestBody MemberStatisticsInfoEntity memberStatisticsInfo){
		memberStatisticsInfoService.updateById(memberStatisticsInfo);
        return R.ok();
    }

    /**
     * 会员统计信息逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "会员统计信息逻辑删除", notes = "会员统计信息逻辑删除")
    //@RequiresPermissions("member:memberstatisticsinfo:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = memberStatisticsInfoService.deleteBathMemberStatisticsInfo(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
