package com.hjht.mall.member.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.member.api.entity.MemberLevelEntity;
import com.hjht.mall.member.service.MemberLevelService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 会员等级
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
@RestController
@RequestMapping("member/memberlevel")
@Api(value = "会员等级控制器}", tags = {"会员等级控制器"})
public class MemberLevelController {
    @Autowired
    private MemberLevelService memberLevelService;

    /**
     * 会员等级列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "会员等级列表查询", notes = "会员等级列表查询")
    //@RequiresPermissions("member:memberlevel:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberLevelService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 会员等级详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "会员等级详情查询", notes = "会员等级详情查询")
    //@RequiresPermissions("member:memberlevel:info")
    public R info(@PathVariable("id") Long id){
		MemberLevelEntity memberLevel = memberLevelService.getById(id);
        return R.ok(memberLevel);
    }

    /**
     * 会员等级保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "会员等级保存", notes = "会员等级保存")
    //@RequiresPermissions("member:memberlevel:save")
    public R save(@RequestBody MemberLevelEntity memberLevel){
        Object result = memberLevelService.saveMemberLevel(memberLevel);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 会员等级修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "会员等级修改", notes = "会员等级修改")
    //@RequiresPermissions("member:memberlevel:update")
    public R update(@RequestBody MemberLevelEntity memberLevel){
		memberLevelService.updateById(memberLevel);
        return R.ok();
    }

    /**
     * 会员等级逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "会员等级逻辑删除", notes = "会员等级逻辑删除")
    //@RequiresPermissions("member:memberlevel:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = memberLevelService.deleteBathMemberLevel(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
