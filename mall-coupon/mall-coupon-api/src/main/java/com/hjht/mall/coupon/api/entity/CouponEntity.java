package com.hjht.mall.coupon.api.entity;

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
 * 优惠券信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@Data
@TableName("sms_coupon")
@ApiModel("优惠券信息")
public class CouponEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * 优惠卷类型[0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券]
     */
    @ApiModelProperty("优惠卷类型[0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券]")
    private Integer couponType;
    /**
     * 优惠券图片
     */
    @ApiModelProperty("优惠券图片")
    private String couponImg;
    /**
     * 优惠卷名字
     */
    @ApiModelProperty("优惠卷名字")
    private String couponName;
    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private Integer num;
    /**
     * 金额
     */
    @ApiModelProperty("金额")
    private BigDecimal amount;
    /**
     * 每人限领张数
     */
    @ApiModelProperty("每人限领张数")
    private Integer perLimit;
    /**
     * 使用门槛
     */
    @ApiModelProperty("使用门槛")
    private BigDecimal minPoint;
    /**
     * 开始时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("开始时间")
    private Date startTime;
    /**
     * 结束时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("结束时间")
    private Date endTime;
    /**
     * 使用类型[0->全场通用；1->指定分类；2->指定商品]
     */
    @ApiModelProperty("使用类型[0->全场通用；1->指定分类；2->指定商品]")
    private Integer useType;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String note;
    /**
     * 发行数量
     */
    @ApiModelProperty("发行数量")
    private Integer publishCount;
    /**
     * 已使用数量
     */
    @ApiModelProperty("已使用数量")
    private Integer useCount;
    /**
     * 领取数量
     */
    @ApiModelProperty("领取数量")
    private Integer receiveCount;
    /**
     * 可以领取的开始日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("可以领取的开始日期")
    private Date enableStartTime;
    /**
     * 可以领取的结束日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("可以领取的结束日期")
    private Date enableEndTime;
    /**
     * 优惠码
     */
    @ApiModelProperty("优惠码")
    private String code;
    /**
     * 可以领取的会员等级[0->不限等级，其他-对应等级]
     */
    @ApiModelProperty("可以领取的会员等级[0->不限等级，其他-对应等级]")
    private Integer memberLevel;
    /**
     * 发布状态[0-未发布，1-已发布]
     */
    @ApiModelProperty("发布状态[0-未发布，1-已发布]")
    private Integer publish;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
