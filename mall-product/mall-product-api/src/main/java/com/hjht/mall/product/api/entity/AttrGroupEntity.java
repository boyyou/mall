package com.hjht.mall.product.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 属性分组
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@Data
@TableName("pms_attr_group")
@ApiModel("属性分组")
public class AttrGroupEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 分组id
     */
    @TableId
    @ApiModelProperty("分组id")
    private Long attrGroupId;
    /**
     * 组名
     */
    @ApiModelProperty("组名")
    private String attrGroupName;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;
    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String descript;
    /**
     * 组图标
     */
    @ApiModelProperty("组图标")
    private String icon;
    /**
     * 所属分类id
     */
    @ApiModelProperty("所属分类id")
    @NotNull(message = "所属分类id不能为空")
    private Long catelogId;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;
}
