package com.hjht.mall.member.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.member.api.entity.MemberSocialEntity;
import com.hjht.mall.member.service.MemberSocialService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 
 * 三方账号控制器
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-30 16:41:28
 */
@RestController
@RequestMapping("member/membersocial")
@Api(value = "三方账号控制器", tags = {"三方账号控制器"})
public class MemberSocialController {
    @Autowired
    private MemberSocialService memberSocialService;

    /**
     * 三方账号列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "三方账号列表查询", notes = "三方账号列表查询")
    //@RequiresPermissions("member:membersocial:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberSocialService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 三方账号详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "三方账号详情查询", notes = "三方账号详情查询")
    //@RequiresPermissions("member:membersocial:info")
    public R info(@PathVariable("id") Long id){
		MemberSocialEntity memberSocial = memberSocialService.getById(id);
        return R.ok(memberSocial);
    }

    /**
     * 三方账号保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "三方账号保存", notes = "三方账号保存")
    //@RequiresPermissions("member:membersocial:save")
    public R save(@RequestBody MemberSocialEntity memberSocial){
        Object result = memberSocialService.saveMemberSocial(memberSocial);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 三方账号修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "三方账号修改", notes = "三方账号修改")
    //@RequiresPermissions("member:membersocial:update")
    public R update(@RequestBody MemberSocialEntity memberSocial){
		memberSocialService.updateById(memberSocial);
        return R.ok();
    }

    /**
     * 三方账号逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "三方账号逻辑删除", notes = "三方账号逻辑删除")
    //@RequiresPermissions("member:membersocial:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = memberSocialService.deleteBathMemberSocial(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
