package com.hjht.mall.product.api.entity;

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
 * 商品评价
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@Data
@TableName("pms_spu_comment")
@ApiModel("商品评价")
public class SpuCommentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * sku_id
     */
    @ApiModelProperty("sku_id")
    private Long skuId;
    /**
     * spu_id
     */
    @ApiModelProperty("spu_id")
    private Long spuId;
    /**
     * 商品名字
     */
    @ApiModelProperty("商品名字")
    private String spuName;
    /**
     * 会员昵称
     */
    @ApiModelProperty("会员昵称")
    private String memberNickName;
    /**
     * 星级
     */
    @ApiModelProperty("星级")
    private Integer star;
    /**
     * 会员ip
     */
    @ApiModelProperty("会员ip")
    private String memberIp;
    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 显示状态[0-不显示，1-显示]
     */
    @ApiModelProperty("显示状态[0-不显示，1-显示]")
    private Integer showStatus;
    /**
     * 购买时属性组合
     */
    @ApiModelProperty("购买时属性组合")
    private String spuAttributes;
    /**
     * 点赞数
     */
    @ApiModelProperty("点赞数")
    private Integer likesCount;
    /**
     * 回复数
     */
    @ApiModelProperty("回复数")
    private Integer replyCount;
    /**
     * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
     */
    @ApiModelProperty("评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]")
    private String resources;
    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String content;
    /**
     * 用户头像
     */
    @ApiModelProperty("用户头像")
    private String memberIcon;
    /**
     * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
     */
    @ApiModelProperty("评论类型[0 - 对商品的直接评论，1 - 对评论的回复]")
    private Integer commentType;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
