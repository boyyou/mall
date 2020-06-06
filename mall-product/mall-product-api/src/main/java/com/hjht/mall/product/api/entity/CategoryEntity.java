package com.hjht.mall.product.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品三级分类
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@Data
@TableName("pms_category")
@ApiModel("商品三级分类")
public class CategoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    @TableId
    @ApiModelProperty("分类id")
    private Long catId;
    /**
     * 分类名称
     */
    @ApiModelProperty("分类名称")
    private String name;
    /**
     * 父分类id
     */
    @ApiModelProperty("父分类id")
    private Long parentCid;
    /**
     * 层级
     */
    @ApiModelProperty("层级")
    private Integer catLevel;
    /**
     * 是否显示[0-不显示，1显示]
     */
    @ApiModelProperty("是否显示[0-不显示，1显示]")
    private Integer showStatus;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;
    /**
     * 图标地址
     */
    @ApiModelProperty("图标地址")
    private String icon;
    /**
     * 计量单位
     */
    @ApiModelProperty("计量单位")
    private String productUnit;
    /**
     * 商品数量
     */
    @ApiModelProperty("商品数量")
    private Integer productCount;

    /**
     * 子分类
     */
    @ApiModelProperty("子分类")
    @TableField(exist = false)
    private List<CategoryEntity> child;

    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", required = false)
    private Date createTime;

    /**
     * 最后一次修改时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后一次修改时间", required = false)
    private Date updateTime;

    @ApiModelProperty("创建人id")
    private Integer createUserId;

    @ApiModelProperty("最后一次修改人id")
    private Integer updateUserId;

}
