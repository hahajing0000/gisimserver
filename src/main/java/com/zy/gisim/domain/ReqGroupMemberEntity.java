package com.zy.gisim.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "群成员请求实体", description = "群成员请求实体")
public class ReqGroupMemberEntity {
    @ApiModelProperty(name = "memberid", value = "群成员id 对应用户表id", notes = "群成员id 对应用户表id", dataType = "int")
    private int memberid;
    @ApiModelProperty(name = "groupid", value = "群组id", notes = "群组id", dataType = "int")
    private int groupid;
    @ApiModelProperty(name = "isowner", value = "是否群主", notes = "是否群主", dataType = "int")
    private int isowner;
    @ApiModelProperty(name = "isadmin", value = "是否管理员 0-否 1-是", notes = "是否管理员 0-否 1-是", dataType = "int")
    private int isadmin;
    @ApiModelProperty(name = "nick", value = "昵称", notes = "昵称", dataType = "String")
    private String nick;
    @ApiModelProperty(name = "status", value = "状态 0-邀请进群 1-申请进群 2-同意进群|已进群 3-拒绝进群", notes = "状态 0-邀请进群 1-申请进群 2-同意进群|已进群 3-拒绝进群", dataType = "int")
    private int status;
}
