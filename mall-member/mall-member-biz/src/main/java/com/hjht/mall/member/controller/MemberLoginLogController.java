package com.hjht.mall.member.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.member.api.entity.MemberLoginLogEntity;
import com.hjht.mall.member.service.MemberLoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 会员登录记录
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
@RestController
@RequestMapping("member/memberloginlog")
@Api(value = "会员登录记录控制器}", tags = {"会员登录记录控制器"})
public class MemberLoginLogController {
    @Autowired
    private MemberLoginLogService memberLoginLogService;

    /**
     * 会员登录记录列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "会员登录记录列表查询", notes = "会员登录记录列表查询")
    //@RequiresPermissions("member:memberloginlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberLoginLogService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 会员登录记录详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "会员登录记录详情查询", notes = "会员登录记录详情查询")
    //@RequiresPermissions("member:memberloginlog:info")
    public R info(@PathVariable("id") Long id){
		MemberLoginLogEntity memberLoginLog = memberLoginLogService.getById(id);
        return R.ok(memberLoginLog);
    }

    /**
     * 会员登录记录保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "会员登录记录保存", notes = "会员登录记录保存")
    //@RequiresPermissions("member:memberloginlog:save")
    public R save(@RequestBody MemberLoginLogEntity memberLoginLog){
        Object result = memberLoginLogService.saveMemberLoginLog(memberLoginLog);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 会员登录记录修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "会员登录记录修改", notes = "会员登录记录修改")
    //@RequiresPermissions("member:memberloginlog:update")
    public R update(@RequestBody MemberLoginLogEntity memberLoginLog){
		memberLoginLogService.updateById(memberLoginLog);
        return R.ok();
    }

    /**
     * 会员登录记录逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "会员登录记录逻辑删除", notes = "会员登录记录逻辑删除")
    //@RequiresPermissions("member:memberloginlog:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = memberLoginLogService.deleteBathMemberLoginLog(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
