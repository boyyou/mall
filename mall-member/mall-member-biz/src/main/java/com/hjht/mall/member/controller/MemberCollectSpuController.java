package com.hjht.mall.member.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.member.api.entity.MemberCollectSpuEntity;
import com.hjht.mall.member.service.MemberCollectSpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 会员收藏的商品
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
@RestController
@RequestMapping("member/membercollectspu")
@Api(value = "会员收藏的商品控制器}", tags = {"会员收藏的商品控制器"})
public class MemberCollectSpuController {
    @Autowired
    private MemberCollectSpuService memberCollectSpuService;

    /**
     * 会员收藏的商品列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "会员收藏的商品列表查询", notes = "会员收藏的商品列表查询")
    //@RequiresPermissions("member:membercollectspu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberCollectSpuService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 会员收藏的商品详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "会员收藏的商品详情查询", notes = "会员收藏的商品详情查询")
    //@RequiresPermissions("member:membercollectspu:info")
    public R info(@PathVariable("id") Long id){
		MemberCollectSpuEntity memberCollectSpu = memberCollectSpuService.getById(id);
        return R.ok(memberCollectSpu);
    }

    /**
     * 会员收藏的商品保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "会员收藏的商品保存", notes = "会员收藏的商品保存")
    //@RequiresPermissions("member:membercollectspu:save")
    public R save(@RequestBody MemberCollectSpuEntity memberCollectSpu){
        Object result = memberCollectSpuService.saveMemberCollectSpu(memberCollectSpu);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 会员收藏的商品修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "会员收藏的商品修改", notes = "会员收藏的商品修改")
    //@RequiresPermissions("member:membercollectspu:update")
    public R update(@RequestBody MemberCollectSpuEntity memberCollectSpu){
		memberCollectSpuService.updateById(memberCollectSpu);
        return R.ok();
    }

    /**
     * 会员收藏的商品逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "会员收藏的商品逻辑删除", notes = "会员收藏的商品逻辑删除")
    //@RequiresPermissions("member:membercollectspu:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = memberCollectSpuService.deleteBathMemberCollectSpu(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
