package com.zy.gisim.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "好友请求实体", description = "好友请求实体")
public class ReqFriendEntity {
    @ApiModelProperty(name = "userid", value = "用户id", notes = "用户id", dataType = "int")
    private int userid;
    @ApiModelProperty(name = "friendid", value = "好友id", notes = "好友id", dataType = "int")
    private int friendid;
    @ApiModelProperty(name = "localgroupid", value = "本地分组id", notes = "本地分组id", dataType = "int")
    private int localgroupid;
    @ApiModelProperty(name = "addtype", value = "添加方式 0-搜索添加 1-扫描添加 2-通讯录添加 ", notes = "添加方式 0-搜索添加 1-扫描添加 2-通讯录添加 ", dataType = "int")
    private int addtype;
    @ApiModelProperty(name = "alias", value = "备注名称", notes = "备注名称", dataType = "String")
    private String alias;

}
