package com.zy.gisim.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "本地分组请求实体", description = "本地分组请求实体")
public class ReqLocalGroupEntity {
    @ApiModelProperty(name = "id", value = "id-创建分组时id不需求传", notes = "id-创建分组时id不需求传", dataType = "int")
    private int id;
    @ApiModelProperty(name = "groupname", value = "分组名称", notes = "分组名称", dataType = "String")
    private String groupname;
    @ApiModelProperty(name = "membercount", value = "组成员数量", notes = "组成员数量", dataType = "int")
    private int membercount;
    @ApiModelProperty(name = "groupdesc", value = "描述信息", notes = "描述信息", dataType = "String")
    private String groupdesc;
    @ApiModelProperty(name = "userid", value = "用户id", notes = "用户id", dataType = "int")
    private int userid;
}
