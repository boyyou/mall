package com.hjht.mall.product.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * 品牌
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@Data
@TableName("pms_brand")
@ApiModel("品牌")
public class BrandEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    @TableId
    @ApiModelProperty("品牌id")
    private Long brandId;
    /**
     * 品牌名
     */
    @ApiModelProperty("品牌名")
    @NotEmpty(message = "品牌名不能为空")
    private String name;
    /**
     * 品牌logo地址
     */
    @ApiModelProperty("品牌logo地址")
    @NotEmpty(message = "品牌logo地址不能为空")
    private String logo;
    /**
     * 介绍
     */
    @ApiModelProperty("介绍")
    @NotEmpty(message = "介绍不能为空")
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     */
    @ApiModelProperty("显示状态[0-不显示；1-显示]")
    private Integer showStatus;
    /**
     * 检索首字母
     */
    @ApiModelProperty("检索首字母")
    private String firstLetter;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;
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


    @TableField(exist = false)
    @ApiModelProperty("分类id")
    private Long catelogId;
}
