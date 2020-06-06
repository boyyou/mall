package com.hjht.mall.member.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hjht.mall.member.api.entity.MemberReceiveAddressEntity;
import com.hjht.mall.member.service.MemberReceiveAddressService;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;



/**
 * 会员收货地址
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:25
 */
@RestController
@RequestMapping("member/memberreceiveaddress")
@Api(value = "会员收货地址控制器}", tags = {"会员收货地址控制器"})
public class MemberReceiveAddressController {
    @Autowired
    private MemberReceiveAddressService memberReceiveAddressService;

    /**
     * 会员收货地址列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "会员收货地址列表查询", notes = "会员收货地址列表查询")
    //@RequiresPermissions("member:memberreceiveaddress:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberReceiveAddressService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 会员收货地址详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "会员收货地址详情查询", notes = "会员收货地址详情查询")
    //@RequiresPermissions("member:memberreceiveaddress:info")
    public R info(@PathVariable("id") Long id){
		MemberReceiveAddressEntity memberReceiveAddress = memberReceiveAddressService.getById(id);
        return R.ok(memberReceiveAddress);
    }

    /**
     * 会员收货地址保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "会员收货地址保存", notes = "会员收货地址保存")
    //@RequiresPermissions("member:memberreceiveaddress:save")
    public R save(@RequestBody MemberReceiveAddressEntity memberReceiveAddress){
        Object result = memberReceiveAddressService.saveMemberReceiveAddress(memberReceiveAddress);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 会员收货地址修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "会员收货地址修改", notes = "会员收货地址修改")
    //@RequiresPermissions("member:memberreceiveaddress:update")
    public R update(@RequestBody MemberReceiveAddressEntity memberReceiveAddress){
		memberReceiveAddressService.updateById(memberReceiveAddress);
        return R.ok();
    }

    /**
     * 会员收货地址逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "会员收货地址逻辑删除", notes = "会员收货地址逻辑删除")
    //@RequiresPermissions("member:memberreceiveaddress:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = memberReceiveAddressService.deleteBathMemberReceiveAddress(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
