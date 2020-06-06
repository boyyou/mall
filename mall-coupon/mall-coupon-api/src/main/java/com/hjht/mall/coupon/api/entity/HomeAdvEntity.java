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
 * 首页轮播广告
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@Data
@TableName("sms_home_adv")
@ApiModel("首页轮播广告")
public class HomeAdvEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * 名字
     */
    @ApiModelProperty("名字")
    private String name;
    /**
     * 图片地址
     */
    @ApiModelProperty("图片地址")
    private String pic;
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
     * 状态
     */
    @ApiModelProperty("状态")
    private Integer status;
    /**
     * 点击数
     */
    @ApiModelProperty("点击数")
    private Integer clickCount;
    /**
     * 广告详情连接地址
     */
    @ApiModelProperty("广告详情连接地址")
    private String url;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String note;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;
    /**
     * 发布者
     */
    @ApiModelProperty("发布者")
    private Long publisherId;
    /**
     * 审核者
     */
    @ApiModelProperty("审核者")
    private Long authId;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
