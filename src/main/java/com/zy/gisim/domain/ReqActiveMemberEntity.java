package com.zy.gisim.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "活动成员请求实体", description = "活动成员请求实体")
public class ReqActiveMemberEntity {
    @ApiModelProperty(name = "memberid", value = "成员id", notes = "成员id", dataType = "int")
    private int memberid;
    @ApiModelProperty(name = "activeid", value = "活动id", notes = "活动id", dataType = "int")
    private int activeid;
    @ApiModelProperty(name = "isowner", value = "是否活动创建人", notes = "是否活动创建人", dataType = "int")
    private int isowner;
    @ApiModelProperty(name = "nick", value = "昵称", notes = "昵称", dataType = "String")
    private String nick;
    @ApiModelProperty(name = "status", value = "状态 0-邀请进群 1-申请进群 2-同意进群|已进群 3-拒绝进群", notes = "状态 0-邀请进群 1-申请进群 2-同意进群|已进群 3-拒绝进群", dataType = "int")
    private int status;
}
