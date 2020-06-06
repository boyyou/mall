package com.hjht.mall.coupon.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 秒杀商品通知订阅
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@Data
@TableName("sms_seckill_sku_notice")
@ApiModel("秒杀商品通知订阅")
public class SeckillSkuNoticeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * member_id
     */
    @ApiModelProperty("member_id")
    private Long memberId;
    /**
     * sku_id
     */
    @ApiModelProperty("sku_id")
    private Long skuId;
    /**
     * 活动场次id
     */
    @ApiModelProperty("活动场次id")
    private Long sessionId;
    /**
     * 订阅时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("订阅时间")
    private Date subcribeTime;
    /**
     * 发送时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("发送时间")
    private Date sendTime;
    /**
     * 通知方式[0-短信，1-邮件]
     */
    @ApiModelProperty("通知方式[0-短信，1-邮件]")
    private Integer noticeType;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
