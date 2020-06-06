package com.hjht.mall.ware.api.entity;

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
 * 采购信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
@Data
@TableName("wms_purchase")
@ApiModel("采购信息")
public class PurchaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 采购单id
     */
    @TableId
    @ApiModelProperty("采购单id")
    private Long id;
    /**
     * 采购人id
     */
    @ApiModelProperty("采购人id")
    private Long assigneeId;
    /**
     * 采购人名
     */
    @ApiModelProperty("采购人名")
    private String assigneeName;
    /**
     * 联系方式
     */
    @ApiModelProperty("联系方式")
    private String phone;
    /**
     * 优先级
     */
    @ApiModelProperty("优先级")
    private Integer priority;
    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Integer status;
    /**
     * 仓库id
     */
    @ApiModelProperty("仓库id")
    private Long wareId;
    /**
     * 总金额
     */
    @ApiModelProperty("总金额")
    private BigDecimal amount;
    /**
     * 创建日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建日期")
    private Date createTime;
    /**
     * 更新日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新日期")
    private Date updateTime;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
