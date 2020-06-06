package com.hjht.mall.ware.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.ware.api.entity.WareOrderTaskDetailEntity;
import com.hjht.mall.ware.service.WareOrderTaskDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 库存工作单
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
@RestController
@RequestMapping("ware/wareordertaskdetail")
@Api(value = "库存工作单控制器}", tags = {"库存工作单控制器"})
public class WareOrderTaskDetailController {
    @Autowired
    private WareOrderTaskDetailService wareOrderTaskDetailService;

    /**
     * 库存工作单列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "库存工作单列表查询", notes = "库存工作单列表查询")
    //@RequiresPermissions("ware:wareordertaskdetail:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = wareOrderTaskDetailService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 库存工作单详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "库存工作单详情查询", notes = "库存工作单详情查询")
    //@RequiresPermissions("ware:wareordertaskdetail:info")
    public R info(@PathVariable("id") Long id){
		WareOrderTaskDetailEntity wareOrderTaskDetail = wareOrderTaskDetailService.getById(id);
        return R.ok(wareOrderTaskDetail);
    }

    /**
     * 库存工作单保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "库存工作单保存", notes = "库存工作单保存")
    //@RequiresPermissions("ware:wareordertaskdetail:save")
    public R save(@RequestBody WareOrderTaskDetailEntity wareOrderTaskDetail){
        Object result = wareOrderTaskDetailService.saveWareOrderTaskDetail(wareOrderTaskDetail);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 库存工作单修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "库存工作单修改", notes = "库存工作单修改")
    //@RequiresPermissions("ware:wareordertaskdetail:update")
    public R update(@RequestBody WareOrderTaskDetailEntity wareOrderTaskDetail){
		wareOrderTaskDetailService.updateById(wareOrderTaskDetail);
        return R.ok();
    }

    /**
     * 库存工作单逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "库存工作单逻辑删除", notes = "库存工作单逻辑删除")
    //@RequiresPermissions("ware:wareordertaskdetail:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = wareOrderTaskDetailService.deleteBathWareOrderTaskDetail(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
