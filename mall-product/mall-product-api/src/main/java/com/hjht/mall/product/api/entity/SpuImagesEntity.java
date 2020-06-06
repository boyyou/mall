package com.hjht.mall.product.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * spu图片
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@Data
@TableName("pms_spu_images")
@ApiModel("spu图片")
public class SpuImagesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * spu_id
     */
    @ApiModelProperty("spu_id")
    private Long spuId;
    /**
     * 图片名
     */
    @ApiModelProperty("图片名")
    private String imgName;
    /**
     * 图片地址
     */
    @ApiModelProperty("图片地址")
    private String imgUrl;
    /**
     * 顺序
     */
    @ApiModelProperty("顺序")
    private Integer imgSort;
    /**
     * 是否默认图
     */
    @ApiModelProperty("是否默认图")
    private Integer defaultImg;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
