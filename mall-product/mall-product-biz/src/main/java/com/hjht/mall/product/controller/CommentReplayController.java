package com.hjht.mall.product.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.entity.CommentReplayEntity;
import com.hjht.mall.product.service.CommentReplayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 商品评价回复关系
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/commentreplay")
@Api(value = "商品评价回复关系控制器}", tags = {"商品评价回复关系控制器"})
public class CommentReplayController {
    @Autowired
    private CommentReplayService commentReplayService;

    /**
     * 商品评价回复关系列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "商品评价回复关系列表查询", notes = "商品评价回复关系列表查询")
    //@RequiresPermissions("product:commentreplay:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = commentReplayService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 商品评价回复关系详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "商品评价回复关系详情查询", notes = "商品评价回复关系详情查询")
    //@RequiresPermissions("product:commentreplay:info")
    public R info(@PathVariable("id") Long id){
		CommentReplayEntity commentReplay = commentReplayService.getById(id);
        return R.ok(commentReplay);
    }

    /**
     * 商品评价回复关系保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "商品评价回复关系保存", notes = "商品评价回复关系保存")
    //@RequiresPermissions("product:commentreplay:save")
    public R save(@RequestBody CommentReplayEntity commentReplay){
        Object result = commentReplayService.saveCommentReplay(commentReplay);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 商品评价回复关系修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "商品评价回复关系修改", notes = "商品评价回复关系修改")
    //@RequiresPermissions("product:commentreplay:update")
    public R update(@RequestBody CommentReplayEntity commentReplay){
		commentReplayService.updateById(commentReplay);
        return R.ok();
    }

    /**
     * 商品评价回复关系逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "商品评价回复关系逻辑删除", notes = "商品评价回复关系逻辑删除")
    //@RequiresPermissions("product:commentreplay:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = commentReplayService.deleteBathCommentReplay(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
