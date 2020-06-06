package com.hjht.mall.product.api.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.hjht.mall.product.api.entity.AttrEntity;
import com.hjht.mall.product.api.entity.AttrGroupEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Date 2020/6/6 9:09
 * @Created by ycl
 */
@Data
public class AttrWithAttrGroupVO extends AttrGroupEntity {

    /**
     * 所属分组下的所有熟悉
     */
    @ApiModelProperty("所属分组下的所有属性")
    private List<AttrEntity> attrs;
}
