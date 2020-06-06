package com.hjht.mall.member.api.entity;

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
 * 成长值变化历史记录
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
@Data
@TableName("ums_growth_change_history")
@ApiModel("成长值变化历史记录")
public class GrowthChangeHistoryEntity implements Serializable {
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
     * create_time
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("create_time")
    private Date createTime;
    /**
     * 改变的值（正负计数）
     */
    @ApiModelProperty("改变的值（正负计数）")
    private Integer changeCount;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String note;
    /**
     * 积分来源[0-购物，1-管理员修改]
     */
    @ApiModelProperty("积分来源[0-购物，1-管理员修改]")
    private Integer sourceType;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
