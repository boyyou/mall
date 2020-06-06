package com.hjht.mall.member.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 会员统计信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:25
 */
@Data
@TableName("ums_member_statistics_info")
@ApiModel("会员统计信息")
public class MemberStatisticsInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * 会员id
     */
    @ApiModelProperty("会员id")
    private Long memberId;
    /**
     * 累计消费金额
     */
    @ApiModelProperty("累计消费金额")
    private BigDecimal consumeAmount;
    /**
     * 累计优惠金额
     */
    @ApiModelProperty("累计优惠金额")
    private BigDecimal couponAmount;
    /**
     * 订单数量
     */
    @ApiModelProperty("订单数量")
    private Integer orderCount;
    /**
     * 优惠券数量
     */
    @ApiModelProperty("优惠券数量")
    private Integer couponCount;
    /**
     * 评价数
     */
    @ApiModelProperty("评价数")
    private Integer commentCount;
    /**
     * 退货数量
     */
    @ApiModelProperty("退货数量")
    private Integer returnOrderCount;
    /**
     * 登录次数
     */
    @ApiModelProperty("登录次数")
    private Integer loginCount;
    /**
     * 关注数量
     */
    @ApiModelProperty("关注数量")
    private Integer attendCount;
    /**
     * 粉丝数量
     */
    @ApiModelProperty("粉丝数量")
    private Integer fansCount;
    /**
     * 收藏的商品数量
     */
    @ApiModelProperty("收藏的商品数量")
    private Integer collectProductCount;
    /**
     * 收藏的专题活动数量
     */
    @ApiModelProperty("收藏的专题活动数量")
    private Integer collectSubjectCount;
    /**
     * 收藏的评论数量
     */
    @ApiModelProperty("收藏的评论数量")
    private Integer collectCommentCount;
    /**
     * 邀请的朋友数量
     */
    @ApiModelProperty("邀请的朋友数量")
    private Integer inviteFriendCount;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
