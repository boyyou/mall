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
 * 积分变化历史记录
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
@Data
@TableName("ums_integration_change_history")
@ApiModel("积分变化历史记录")
public class IntegrationChangeHistoryEntity implements Serializable {
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
     * 变化的值
     */
    @ApiModelProperty("变化的值")
    private Integer changeCount;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String note;
    /**
     * 来源[0->购物；1->管理员修改;2->活动]
     */
    @ApiModelProperty("来源[0->购物；1->管理员修改;2->活动]")
    private Integer sourceTyoe;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
