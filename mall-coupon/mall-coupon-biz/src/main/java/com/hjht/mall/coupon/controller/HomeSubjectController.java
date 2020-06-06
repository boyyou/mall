package com.hjht.mall.coupon.controller;

import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.R;
import com.hjht.mall.coupon.api.entity.HomeSubjectEntity;
import com.hjht.mall.coupon.service.HomeSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@RestController
@RequestMapping("coupon/homesubject")
@Api(value = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】控制器}", tags = {"首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】控制器"})
public class HomeSubjectController {
    @Autowired
    private HomeSubjectService homeSubjectService;

    /**
     * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】列表查询", notes = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】列表查询")
    //@RequiresPermissions("coupon:homesubject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = homeSubjectService.queryPage(params);
        return R.ok(page);
    }


    /**
     * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】详情查询
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】详情查询", notes = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】详情查询")
    //@RequiresPermissions("coupon:homesubject:info")
    public R info(@PathVariable("id") Long id){
		HomeSubjectEntity homeSubject = homeSubjectService.getById(id);
        return R.ok(homeSubject);
    }

    /**
     * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】保存", notes = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】保存")
    //@RequiresPermissions("coupon:homesubject:save")
    public R save(@RequestBody HomeSubjectEntity homeSubject){
        Object result = homeSubjectService.saveHomeSubject(homeSubject);
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

    /**
     * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】修改", notes = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】修改")
    //@RequiresPermissions("coupon:homesubject:update")
    public R update(@RequestBody HomeSubjectEntity homeSubject){
		homeSubjectService.updateById(homeSubject);
        return R.ok();
    }

    /**
     * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】逻辑删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】逻辑删除", notes = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】逻辑删除")
    //@RequiresPermissions("coupon:homesubject:delete")
    public R delete(@RequestBody Long[] ids){
        Object result = homeSubjectService.deleteBathHomeSubject(Arrays.asList(ids));
        if (result instanceof Boolean){
            return R.ok();
        }else {
            return R.fail(result.toString());
        }
    }

}
