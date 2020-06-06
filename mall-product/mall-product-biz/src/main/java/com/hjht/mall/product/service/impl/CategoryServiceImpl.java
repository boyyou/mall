package com.hjht.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.product.api.constant.ProductConstant;
import com.hjht.mall.product.api.entity.CategoryEntity;
import com.hjht.mall.product.dao.CategoryDao;
import com.hjht.mall.product.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listCategory() {
        //查询出所有的分类
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        //过滤出一级分类
        /*List<CategoryEntity> leveOne = categoryEntities.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid() == 0;
        }).collect(Collectors.toList());*/
        //这个java8的特性，如果只有一个参数以及过滤的条件只有一条语句的话就可以省略()和{}即参数只有categoryEntity，过滤的条件也只有一句categoryEntity.getParentCid() == 0
        //1、挑选出所有一级分类即parentId=0
        List<CategoryEntity> leveOne = categoryEntities.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == 0
        ).map((category)->{
            //2、设置这些一级分类的子分类
            category.setChild(setChild(category,categoryEntities));
            return category;
        }).sorted((category1,category2)->{
            //3、进行排序
            return (category2.getSort() == null ? 0 : category2.getSort()) - (category1.getSort() == null ? 0:category1.getSort());
        }).collect(Collectors.toList());
        return leveOne;
    }

    @Override
    public List<CategoryEntity> getParentPath(Long categoryId) {
        CategoryEntity byId = baseMapper.selectById(categoryId);
        List<CategoryEntity> result = new ArrayList<>();
        List<CategoryEntity> categoryEntities = queryParent(byId, result);
        return categoryEntities;
    }

    /**
     * 递归查找父级分类
     * @return
     */
    private List<CategoryEntity> queryParent(CategoryEntity categoryId,List<CategoryEntity> result){
        result.add(categoryId);
        if (categoryId.getParentCid() != 0){
            CategoryEntity byId = baseMapper.selectById(categoryId.getParentCid());
            queryParent(byId,result);
        }
        return result;
    }

    @Override
    public Object deleteBath(List<Long> asList) {
        if (CollectionUtils.isEmpty(asList)){
            return "请选择删除的分类!";
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.in("parent_cid",asList);
        List<CategoryEntity> list = baseMapper.selectList(queryWrapper);
        if (!CollectionUtils.isEmpty(list)){
            return "所选分类中包含含有子分类的分类!";
        }
        baseMapper.deleteBatchIds(asList);
        return Boolean.TRUE;
    }

    @Override
    public Object saveCategory(CategoryEntity categoryEntity) {
        if (categoryEntity.getParentCid() == null){
            categoryEntity.setParentCid(0L);
        }else {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq(ProductConstant.CAT_ID, categoryEntity.getParentCid());
            List<CategoryEntity> list = baseMapper.selectList(queryWrapper);
            if (CollectionUtils.isEmpty(list)){
                return "所选父级分类不存在!";
            }else if(list.get(0).getCatLevel() == 3){
                return "所选父级已是第三级，不支持子分类添加!";
            }
        }
        baseMapper.insert(categoryEntity);
        return Boolean.TRUE;
    }

    /**
     * 修改分类信息
     * @param categoryEntity
     * @return
     */
    @Override
    public Object updateCategory(CategoryEntity categoryEntity) {
        QueryWrapper<CategoryEntity> queryWrapper = new QueryWrapper();
        queryWrapper.eq(ProductConstant.CAT_ID, categoryEntity.getCatId());
        List<CategoryEntity> list = baseMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(list)){
            return "该分类不存在!";
        }
        if (categoryEntity.getParentCid() != null){
            QueryWrapper<CategoryEntity> queryWrapperParent = new QueryWrapper();
            queryWrapperParent.eq(ProductConstant.CAT_ID, categoryEntity.getParentCid());
            List<CategoryEntity> listParent = baseMapper.selectList(queryWrapper);
            if (CollectionUtils.isEmpty(listParent)){
                return "所选父级分类不存在";
            }else if (listParent.get(0).getCatLevel() == 3){
                return "所选父级已是第三级，不支持子分类添加!";
            }else if (listParent.get(0).getCatLevel() + list.get(0).getCatLevel() > 3){
                return "分类移入超过三级!";
            }
        }
        return null;
    }

    /**
     * 递归找出某个分类的所有子分类
     * @param root
     * @param all
     * @return
     */
    private List<CategoryEntity> setChild(CategoryEntity root,List<CategoryEntity> all){
        List<CategoryEntity> collect = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(root.getCatId());
        }).map((category) -> {
            category.setChild(setChild(category,all));
            return category;
        }).sorted((category1,category2)->{
            return (category2.getSort() == null ? 0 : category2.getSort()) - (category1.getSort() == null ? 0:category1.getSort());
        }).collect(Collectors.toList());
        return collect;
    }

}