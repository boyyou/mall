package com.hjht.mall.product.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.entity.SpuInfoEntity;
import com.hjht.mall.product.api.vo.SpuSaveVo;
import com.hjht.mall.product.service.SpuInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * spu信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/spuinfo")
@Api(value = "spu信息控制器}", tags = {"spu信息控制器"})
public class SpuInfoController {
    @Autowired
    private SpuInfoService spuInfoService;

    /**
     * spu信息列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "spu信息列表查询", notes = "spu信息列表查询")
    //@RequiresPermissions("product:spuinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spuInfoService.queryPage(params);
        return R.ok(page);
    }


    /**
     * spu信息详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "spu信息详情查询", notes = "spu信息详情查询")
    //@RequiresPermissions("product:spuinfo:info")
    public R info(@PathVariable("id") Long id){
		SpuInfoEntity spuInfo = spuInfoService.getById(id);
        return R.ok(spuInfo);
    }

    /**
     * spu信息保存-商品发布
     */
    @PostMapping("/save")
    @ApiOperation(value = "spu信息保存-商品发布", notes = "spu信息保存-商品发布")
    //@RequiresPermissions("product:spuinfo:save")
    public R save(@Valid @RequestBody SpuSaveVo spuSaveVo){
        Object result = spuInfoService.saveSpuInfo(spuSaveVo);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * spu信息修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "spu信息修改", notes = "spu信息修改")
    //@RequiresPermissions("product:spuinfo:update")
    public R update(@RequestBody SpuInfoEntity spuInfo){
		spuInfoService.updateById(spuInfo);
        return R.ok();
    }

    /**
     * spu信息逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "spu信息逻辑删除", notes = "spu信息逻辑删除")
    //@RequiresPermissions("product:spuinfo:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = spuInfoService.deleteBathSpuInfo(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
