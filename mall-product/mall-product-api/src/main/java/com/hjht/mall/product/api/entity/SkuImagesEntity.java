package com.hjht.mall.product.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * sku图片
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@Data
@TableName("pms_sku_images")
@ApiModel("sku图片")
public class SkuImagesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * sku_id
     */
    @ApiModelProperty("sku_id")
    private Long skuId;
    /**
     * 图片地址
     */
    @ApiModelProperty("图片地址")
    private String imgUrl;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer imgSort;
    /**
     * 默认图[0 - 不是默认图，1 - 是默认图]
     */
    @ApiModelProperty("默认图[0 - 不是默认图，1 - 是默认图]")
    private Integer defaultImg;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
