package com.hjht.mall.product.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 属性&属性分组关联
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@Data
@TableName("pms_attr_attrgroup_relation")
@ApiModel("属性&属性分组关联")
public class AttrAttrgroupRelationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * 属性id
     */
    @ApiModelProperty("属性id")
    private Long attrId;
    /**
     * 属性分组id
     */
    @ApiModelProperty("属性分组id")
    private Long attrGroupId;
    /**
     * 属性组内排序
     */
    @ApiModelProperty("属性组内排序")
    private Integer attrSort;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
