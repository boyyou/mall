package com.hjht.mall.product.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.product.api.entity.AttrAttrgroupRelationEntity;
import com.hjht.mall.product.service.AttrAttrgroupRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 属性&属性分组关联
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@RestController
@RequestMapping("product/attrattrgrouprelation")
@Api(value = "属性&属性分组关联控制器}", tags = {"属性&属性分组关联控制器"})
public class AttrAttrgroupRelationController {
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    /**
     * 属性&属性分组关联列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "属性&属性分组关联列表查询", notes = "属性&属性分组关联列表查询")
    //@RequiresPermissions("product:attrattrgrouprelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrAttrgroupRelationService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 属性&属性分组关联详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "属性&属性分组关联详情查询", notes = "属性&属性分组关联详情查询")
    //@RequiresPermissions("product:attrattrgrouprelation:info")
    public R info(@PathVariable("id") Long id){
		AttrAttrgroupRelationEntity attrAttrgroupRelation = attrAttrgroupRelationService.getById(id);
        return R.ok(attrAttrgroupRelation);
    }

    /**
     * 属性&属性分组关联保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "属性&属性分组关联保存", notes = "属性&属性分组关联保存")
    //@RequiresPermissions("product:attrattrgrouprelation:save")
    public R save(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelation){
        Object result = attrAttrgroupRelationService.saveAttrAttrgroupRelation(attrAttrgroupRelation);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 属性&属性分组关联修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "属性&属性分组关联修改", notes = "属性&属性分组关联修改")
    //@RequiresPermissions("product:attrattrgrouprelation:update")
    public R update(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelation){
		attrAttrgroupRelationService.updateById(attrAttrgroupRelation);
        return R.ok();
    }

    /**
     * 属性&属性分组关联逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "属性&属性分组关联逻辑删除", notes = "属性&属性分组关联逻辑删除")
    //@RequiresPermissions("product:attrattrgrouprelation:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = attrAttrgroupRelationService.deleteBathAttrAttrgroupRelation(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
