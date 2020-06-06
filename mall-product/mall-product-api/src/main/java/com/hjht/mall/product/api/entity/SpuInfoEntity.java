package com.hjht.mall.product.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * spu信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@Data
@TableName("pms_spu_info")
@ApiModel("spu信息")
public class SpuInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId
    @ApiModelProperty("商品id")
    private Long id;
    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String spuName;
    /**
     * 商品描述
     */
    @ApiModelProperty("商品描述")
    private String spuDescription;
    /**
     * 所属分类id
     */
    @ApiModelProperty("所属分类id")
    private Long catalogId;
    /**
     * 品牌id
     */
    @ApiModelProperty("品牌id")
    private Long brandId;
    /**
     *
     */
    @ApiModelProperty("")
    private BigDecimal weight;
    /**
     * 上架状态[0 - 下架，1 - 上架]
     */
    @ApiModelProperty("上架状态[0 - 下架，1 - 上架]")
    private Integer publishStatus;
    /**
     *
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("")
    private Date createTime;
    /**
     *
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("")
    private Date updateTime;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
