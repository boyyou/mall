package com.hjht.mall.member.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 会员收藏的专题活动
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
@Data
@TableName("ums_member_collect_subject")
@ApiModel("会员收藏的专题活动")
public class MemberCollectSubjectEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * subject_id
     */
    @ApiModelProperty("subject_id")
    private Long subjectId;
    /**
     * subject_name
     */
    @ApiModelProperty("subject_name")
    private String subjectName;
    /**
     * subject_img
     */
    @ApiModelProperty("subject_img")
    private String subjectImg;
    /**
     * 活动url
     */
    @ApiModelProperty("活动url")
    private String subjectUrll;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
