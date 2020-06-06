package com.hjht.mall.ware.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 商品库存
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
@Data
@TableName("wms_ware_sku")
@ApiModel("商品库存")
public class WareSkuEntity implements Serializable {
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
     * 仓库id
     */
    @ApiModelProperty("仓库id")
    private Long wareId;
    /**
     * 库存数
     */
    @ApiModelProperty("库存数")
    private Integer stock;
    /**
     * sku_name
     */
    @ApiModelProperty("sku_name")
    private String skuName;
    /**
     * 锁定库存
     */
    @ApiModelProperty("锁定库存")
    private Integer stockLocked;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
