package com.hjht.mall.member.api.entity;

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
 * 会员等级
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
@Data
@TableName("ums_member_level")
@ApiModel("会员等级")
public class MemberLevelEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * 等级名称
     */
    @ApiModelProperty("等级名称")
    private String name;
    /**
     * 等级需要的成长值
     */
    @ApiModelProperty("等级需要的成长值")
    private Integer growthPoint;
    /**
     * 是否为默认等级[0->不是；1->是]
     */
    @ApiModelProperty("是否为默认等级[0->不是；1->是]")
    private Integer defaultStatus;
    /**
     * 免运费标准
     */
    @ApiModelProperty("免运费标准")
    private BigDecimal freeFreightPoint;
    /**
     * 每次评价获取的成长值
     */
    @ApiModelProperty("每次评价获取的成长值")
    private Integer commentGrowthPoint;
    /**
     * 是否有免邮特权
     */
    @ApiModelProperty("是否有免邮特权")
    private Integer priviledgeFreeFreight;
    /**
     * 是否有会员价格特权
     */
    @ApiModelProperty("是否有会员价格特权")
    private Integer priviledgeMemberPrice;
    /**
     * 是否有生日特权
     */
    @ApiModelProperty("是否有生日特权")
    private Integer priviledgeBirthday;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String note;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", required = false)
    private Date createTime;

    /**
     * 最后一次修改时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后一次修改时间", required = false)
    private Date updateTime;

    @ApiModelProperty("创建人id")
    private Integer createUserId;

    @ApiModelProperty("最后一次修改人id")
    private Integer updateUserId;

}
