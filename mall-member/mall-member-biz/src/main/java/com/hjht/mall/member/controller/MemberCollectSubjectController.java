package com.hjht.mall.member.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.member.api.entity.MemberCollectSubjectEntity;
import com.hjht.mall.member.service.MemberCollectSubjectService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 会员收藏的专题活动
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
@RestController
@RequestMapping("member/membercollectsubject")
@Api(value = "会员收藏的专题活动控制器}", tags = {"会员收藏的专题活动控制器"})
public class MemberCollectSubjectController {
    @Autowired
    private MemberCollectSubjectService memberCollectSubjectService;

    /**
     * 会员收藏的专题活动列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "会员收藏的专题活动列表查询", notes = "会员收藏的专题活动列表查询")
    //@RequiresPermissions("member:membercollectsubject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberCollectSubjectService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 会员收藏的专题活动详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "会员收藏的专题活动详情查询", notes = "会员收藏的专题活动详情查询")
    //@RequiresPermissions("member:membercollectsubject:info")
    public R info(@PathVariable("id") Long id){
		MemberCollectSubjectEntity memberCollectSubject = memberCollectSubjectService.getById(id);
        return R.ok(memberCollectSubject);
    }

    /**
     * 会员收藏的专题活动保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "会员收藏的专题活动保存", notes = "会员收藏的专题活动保存")
    //@RequiresPermissions("member:membercollectsubject:save")
    public R save(@RequestBody MemberCollectSubjectEntity memberCollectSubject){
        Object result = memberCollectSubjectService.saveMemberCollectSubject(memberCollectSubject);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 会员收藏的专题活动修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "会员收藏的专题活动修改", notes = "会员收藏的专题活动修改")
    //@RequiresPermissions("member:membercollectsubject:update")
    public R update(@RequestBody MemberCollectSubjectEntity memberCollectSubject){
		memberCollectSubjectService.updateById(memberCollectSubject);
        return R.ok();
    }

    /**
     * 会员收藏的专题活动逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "会员收藏的专题活动逻辑删除", notes = "会员收藏的专题活动逻辑删除")
    //@RequiresPermissions("member:membercollectsubject:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = memberCollectSubjectService.deleteBathMemberCollectSubject(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
