package com.hjht.mall.product.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.entity.SpuCommentEntity;
import com.hjht.mall.product.service.SpuCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 商品评价
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/spucomment")
@Api(value = "商品评价控制器}", tags = {"商品评价控制器"})
public class SpuCommentController {
    @Autowired
    private SpuCommentService spuCommentService;

    /**
     * 商品评价列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "商品评价列表查询", notes = "商品评价列表查询")
    //@RequiresPermissions("product:spucomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spuCommentService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 商品评价详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "商品评价详情查询", notes = "商品评价详情查询")
    //@RequiresPermissions("product:spucomment:info")
    public R info(@PathVariable("id") Long id){
		SpuCommentEntity spuComment = spuCommentService.getById(id);
        return R.ok(spuComment);
    }

    /**
     * 商品评价保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "商品评价保存", notes = "商品评价保存")
    //@RequiresPermissions("product:spucomment:save")
    public R save(@RequestBody SpuCommentEntity spuComment){
        Object result = spuCommentService.saveSpuComment(spuComment);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 商品评价修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "商品评价修改", notes = "商品评价修改")
    //@RequiresPermissions("product:spucomment:update")
    public R update(@RequestBody SpuCommentEntity spuComment){
		spuCommentService.updateById(spuComment);
        return R.ok();
    }

    /**
     * 商品评价逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "商品评价逻辑删除", notes = "商品评价逻辑删除")
    //@RequiresPermissions("product:spucomment:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = spuCommentService.deleteBathSpuComment(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
