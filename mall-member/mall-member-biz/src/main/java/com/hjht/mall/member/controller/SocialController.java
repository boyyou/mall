package com.hjht.mall.member.controller;

import com.hjht.common.utils.R;
import com.hjht.mall.member.api.dto.SocialLoginEntity;
import com.hjht.mall.member.api.entity.MemberSocialEntity;
import com.hjht.mall.member.api.vo.MemberLoginVO;
import com.hjht.mall.member.api.vo.MemberResultVO;
import com.hjht.mall.member.service.SocialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Date 2020/5/30 15:37
 * @Created by ycl
 */
@RestController
@RequestMapping("social")
@Api(value = "社交登陆控制器", tags = {"社交登录控制器"})
public class SocialController {

    @Autowired
    private SocialService socialService;

    /**
     * 社交登陆接口
     */
    @PostMapping("/login")
    @ApiOperation(value = "社交登陆接口", notes = "社交登陆接口")
    //@RequiresPermissions("member:member:save")
    public R login(@Valid @RequestBody SocialLoginEntity socialLoginEntity) {
        socialService.login(socialLoginEntity);
        return R.ok();
    }

    /**
     * 微信小程序登陆接口
     */
    @PostMapping("/callback/wx")
    @ApiOperation(value = "微信小程序登陆接口", notes = "微信小程序登陆接口")
    //@RequiresPermissions("member:member:save")
    public R callbackWeChat(String code) {
        /*HttpSession session = request.getSession();
        session.setAttribute("ycl","123");*/
        MemberLoginVO memberLoginVO = socialService.callbackWeChat(code);
        return R.ok(memberLoginVO);
    }

    /**
     * 微信小程序授权后补全用户信息
     */
    @PostMapping("/completion/wx")
    @ApiOperation(value = "微信小程序授权后补全用户信息", notes = "微信小程序授权后补全用户信息")
    //@RequiresPermissions("member:member:save")
    public R callbackWeChat(SocialLoginEntity socialLoginEntity) {
        MemberLoginVO memberLoginVO = socialService.completionSocialInfo(socialLoginEntity);
        return R.ok(memberLoginVO);
    }

    /**
     * 支付宝登陆回调接口
     */
    @PostMapping("/callback/alipay")
    @ApiOperation(value = "支付宝登陆回调接口", notes = "支付宝登陆回调接口")
    //@RequiresPermissions("member:member:save")
    public R callbackAliPay() {
        return R.ok();
    }

    /**
     * 微博登陆回调接口
     */
    @PostMapping("/callback/wb")
    @ApiOperation(value = "微博登陆回调接口", notes = "微博登陆回调接口")
    //@RequiresPermissions("member:member:save")
    public R callbackWB() {
        return R.ok();
    }

    /**
     * 抖音登陆回调接口
     */
    @PostMapping("/callback/dy")
    @ApiOperation(value = "抖音登陆回调接口", notes = "抖音登陆回调接口")
    //@RequiresPermissions("member:member:save")
    public R callbackDY() {
        return R.ok();
    }

    /**
     * 头条登陆回调接口
     */
    @PostMapping("/callback/tt")
    @ApiOperation(value = "头条登陆回调接口", notes = "头条登陆回调接口")
    //@RequiresPermissions("member:member:save")
    public R callbackTT() {
        return R.ok();
    }

    /**
     * 根据输入流获取回调的数据
     * @param is
     * @return
     */
    private String readRequestData(InputStream is){
        StringBuilder content = new StringBuilder();
        byte[] b = new byte[1024];
        int lens = -1;
        try {
            while ((lens = is.read(b)) > 0) {
                content.append(new String(b, 0, lens));
            }
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("数据解析异常");
        }
        return content.toString();
    }

}
