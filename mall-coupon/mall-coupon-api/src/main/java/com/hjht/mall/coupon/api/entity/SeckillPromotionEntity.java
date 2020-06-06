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
 * 秒杀活动
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@Data
@TableName("sms_seckill_promotion")
@ApiModel("秒杀活动")
public class SeckillPromotionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * 活动标题
     */
    @ApiModelProperty("活动标题")
    private String title;
    /**
     * 开始日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("开始日期")
    private Date startTime;
    /**
     * 结束日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("结束日期")
    private Date endTime;
    /**
     * 上下线状态
     */
    @ApiModelProperty("上下线状态")
    private Integer status;
    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private Long userId;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
