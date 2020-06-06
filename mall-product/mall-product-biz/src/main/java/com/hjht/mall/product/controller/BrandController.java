package com.hjht.mall.product.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.entity.BrandEntity;
import com.hjht.mall.product.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 品牌
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/brand")
@Api(value = "品牌控制器}", tags = {"品牌控制器"})
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 品牌列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "品牌列表查询", notes = "品牌列表查询")
    //@RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 品牌详情查询
     */
    @GetMapping("/info/{brandId}")
    @ApiOperation(value = "品牌详情查询", notes = "品牌详情查询")
    //@RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);
        return R.ok(brand);
    }

    /**
     * 品牌保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "品牌保存", notes = "品牌保存")
    //@RequiresPermissions("product:brand:save")
    public R save(@Valid @RequestBody BrandEntity brand){
        Object result = brandService.saveBrand(brand);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 品牌修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "品牌修改", notes = "品牌修改")
    //@RequiresPermissions("product:brand:update")
    public R update(@RequestBody BrandEntity brand){
		brandService.updateById(brand);
        return R.ok();
    }

    /**
     * 品牌逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "品牌逻辑删除", notes = "品牌逻辑删除")
    //@RequiresPermissions("product:brand:delete")
    public R delete(@RequestBody Long[] brandIds){
        Object result = brandService.deleteBathBrand(Arrays.asList(brandIds));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
