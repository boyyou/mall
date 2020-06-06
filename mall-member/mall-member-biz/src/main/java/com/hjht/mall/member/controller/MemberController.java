package com.hjht.mall.member.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.coupon.api.feign.CouponFeign;
import com.hjht.mall.member.api.dto.MemberLoginDTO;
import com.hjht.mall.member.api.dto.MemberRegisterDTO;
import com.hjht.mall.member.api.entity.MemberEntity;
import com.hjht.mall.member.api.vo.MemberResultVO;
import com.hjht.mall.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;


/**
 * 会员
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
@RestController
@RequestMapping("member/member")
@Api(value = "会员控制器}", tags = {"会员控制器"})
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private CouponFeign couponFeign;

    @GetMapping("/test")
    public R test() {
        return R.ok(couponFeign.list().getData());
    }

    /**
     * 会员列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "会员列表查询", notes = "会员列表查询")
    //@RequiresPermissions("member:member:list")
    public R<List<MemberEntity>> list(@RequestParam Map<String, Object> params) {
        PageUtils page = memberService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 会员详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "会员详情查询", notes = "会员详情查询")
    //@RequiresPermissions("member:member:info")
    public R<MemberEntity> info(@PathVariable("id") Long id) {
        MemberEntity member = memberService.getById(id);
        return R.ok(member);
    }

    /**
     * 会员保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "会员保存", notes = "会员保存")
    //@RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member) {
        Object result = memberService.saveMember(member);
        if (result instanceof Boolean) {
            return R.ok();
        } else {
            return R.fail(result.toString());
        }
    }

    /**
     * 会员注册
     */
    @PostMapping("/register")
    @ApiOperation(value = "会员注册", notes = "会员注册")
    //@RequiresPermissions("member:member:save")
    public R register(@Valid @RequestBody MemberRegisterDTO memberRegisterDTO) {
        Object o = memberService.registerMember(memberRegisterDTO);
        MemberResultVO memberResultVO = new MemberResultVO();
        memberResultVO.setAccessToken(o.toString());
        return R.ok(o);
    }

    /**
     * 会员登陆
     */
    @PostMapping("/login")
    @ApiOperation(value = "会员登陆", notes = "会员登陆")
    //@RequiresPermissions("member:member:save")
    public R login(@Valid @RequestBody MemberLoginDTO memberRegisterDTO, HttpServletRequest request) {
        Object o = memberService.loginMember(memberRegisterDTO);
        /*HttpSession session = request.getSession();
        session.setAttribute(RedisConstant.SESSION_NAME,o);*/
        MemberResultVO memberResultVO = new MemberResultVO();
        memberResultVO.setAccessToken(String.valueOf(o));
        return R.ok(memberResultVO);
    }

    /**
     * 会员登出
     */
    @PostMapping("/un_login")
    @ApiOperation(value = "会员登出", notes = "会员登出")
    //@RequiresPermissions("member:member:save")
    public R unLogin(HttpServletRequest request) {
        memberService.unLoginMember(request.getHeader("accessToken"));
        /*HttpSession session = request.getSession();
        session.setAttribute(RedisConstant.SESSION_NAME,o);*/
        return R.ok();
    }

    /**
     * 会员修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "会员修改", notes = "会员修改")
    //@RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member) {
        memberService.updateById(member);
        return R.ok();
    }

    /**
     * 会员逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "会员逻辑删除", notes = "会员逻辑删除")
    //@RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids) {
        Object result = memberService.deleteBathMember(Arrays.asList(ids));
        if (result instanceof Boolean) {
            return R.ok();
        } else {
            return R.fail(result.toString());
        }
    }

    /**
     * 会员注册短信验证码发送
     */
    @PostMapping("/send/sms")
    @ApiOperation(value = "会员注册短信验证码发送", notes = "会员注册短信验证码发送")
    //@RequiresPermissions("coupon:coupon:list")
    public R sendSms(@RequestBody String phone) {
        Object o = memberService.sendSms(phone);
        if (o instanceof Boolean) {
            return R.ok();
        } else {
            return R.fail(o.toString());
        }
    }

}
