package com.hjht.mall.product.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.entity.ProductAttrValueEntity;
import com.hjht.mall.product.service.ProductAttrValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * spu属性值
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/productattrvalue")
@Api(value = "spu属性值控制器}", tags = {"spu属性值控制器"})
public class ProductAttrValueController {
    @Autowired
    private ProductAttrValueService productAttrValueService;

    /**
     * spu属性值列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "spu属性值列表查询", notes = "spu属性值列表查询")
    //@RequiresPermissions("product:productattrvalue:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productAttrValueService.queryPage(params);
        return R.ok(page);
    }


    /**
     * spu属性值详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "spu属性值详情查询", notes = "spu属性值详情查询")
    //@RequiresPermissions("product:productattrvalue:info")
    public R info(@PathVariable("id") Long id){
		ProductAttrValueEntity productAttrValue = productAttrValueService.getById(id);
        return R.ok(productAttrValue);
    }

    /**
     * spu属性值保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "spu属性值保存", notes = "spu属性值保存")
    //@RequiresPermissions("product:productattrvalue:save")
    public R save(@RequestBody ProductAttrValueEntity productAttrValue){
        Object result = productAttrValueService.saveProductAttrValue(productAttrValue);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * spu属性值修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "spu属性值修改", notes = "spu属性值修改")
    //@RequiresPermissions("product:productattrvalue:update")
    public R update(@RequestBody ProductAttrValueEntity productAttrValue){
		productAttrValueService.updateById(productAttrValue);
        return R.ok();
    }

    /**
     * spu属性值逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "spu属性值逻辑删除", notes = "spu属性值逻辑删除")
    //@RequiresPermissions("product:productattrvalue:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = productAttrValueService.deleteBathProductAttrValue(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
