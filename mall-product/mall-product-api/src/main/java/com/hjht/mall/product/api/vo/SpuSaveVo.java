package com.hjht.mall.product.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Date 2020/6/6 10:06
 * @Created by ycl
 */
@Data
public class SpuSaveVo {
    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称比如：一加 OnePlus 8")
    @NotEmpty(message = "商品名称不能为空")
    private String spuName;

    @ApiModelProperty("商品描述")
    @NotEmpty(message = "商品描述不能为空")
    private String spuDescription;

    @ApiModelProperty("所属分类")
    @NotNull(message = "所属分类不能为空")
    private Long catalogId;

    @ApiModelProperty("所属品牌")
    @NotNull(message = "所属品牌不能为空")
    private Long brandId;

    @ApiModelProperty("商品重量")
    @NotEmpty(message = "商品重量不能为空")
    private BigDecimal weight;

    @ApiModelProperty("上架状态[0 - 下架，1 - 上架]")
    private int publishStatus;

    @ApiModelProperty("商品描述")
    @NotEmpty(message = "商品描述不能为空")
    private List<String> decript;

    @ApiModelProperty("spu图片集合")
    @NotEmpty(message = "spu图片集合不能为空")
    private List<String> images;


    @ApiModelProperty("会员成长值积分等")
    @Valid
    private Bounds bounds;

    @ApiModelProperty("spu基本属性")
    @NotEmpty(message = "spu基本属性不能为空")
    private List<BaseAttrs> baseAttrs;

    @ApiModelProperty("商品sku信息")
    @NotEmpty(message = "商品sku信息不能为空")
    private List<Skus> skus;
}
