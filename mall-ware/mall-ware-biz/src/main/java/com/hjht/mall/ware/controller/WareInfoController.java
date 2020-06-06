package com.hjht.mall.ware.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.ware.api.entity.WareInfoEntity;
import com.hjht.mall.ware.service.WareInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 仓库信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
@RestController
@RequestMapping("ware/wareinfo")
@Api(value = "仓库信息控制器}", tags = {"仓库信息控制器"})
public class WareInfoController {
    @Autowired
    private WareInfoService wareInfoService;

    /**
     * 仓库信息列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "仓库信息列表查询", notes = "仓库信息列表查询")
    //@RequiresPermissions("ware:wareinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = wareInfoService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 仓库信息详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "仓库信息详情查询", notes = "仓库信息详情查询")
    //@RequiresPermissions("ware:wareinfo:info")
    public R info(@PathVariable("id") Long id){
		WareInfoEntity wareInfo = wareInfoService.getById(id);
        return R.ok(wareInfo);
    }

    /**
     * 仓库信息保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "仓库信息保存", notes = "仓库信息保存")
    //@RequiresPermissions("ware:wareinfo:save")
    public R save(@RequestBody WareInfoEntity wareInfo){
        Object result = wareInfoService.saveWareInfo(wareInfo);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 仓库信息修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "仓库信息修改", notes = "仓库信息修改")
    //@RequiresPermissions("ware:wareinfo:update")
    public R update(@RequestBody WareInfoEntity wareInfo){
		wareInfoService.updateById(wareInfo);
        return R.ok();
    }

    /**
     * 仓库信息逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "仓库信息逻辑删除", notes = "仓库信息逻辑删除")
    //@RequiresPermissions("ware:wareinfo:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = wareInfoService.deleteBathWareInfo(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
