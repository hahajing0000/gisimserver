package com.zy.gisim.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "群组请求实体", description = "群组请求实体")
public class ReqGroupEntity {
    @ApiModelProperty(name = "groupname", value = "群组名称", notes = "群组名称", dataType = "String")
    private String groupname;
    @ApiModelProperty(name = "groupdesc", value = "群组描述", notes = "群组描述", dataType = "String")
    private String groupdesc;
    @ApiModelProperty(name = "owner", value = "群主id", notes = "群主id", dataType = "int")
    private int owner;
    @ApiModelProperty(name = "grouptypeid", value = "群类型id", notes = "群类型id", dataType = "int")
    private int grouptypeid;
    @ApiModelProperty(name = "grouptypename", value = "群类型名称", notes = "群类型名称", dataType = "String")
    private String grouptypename;
    @ApiModelProperty(name = "imgpath", value = "群头像地址", notes = "群头像地址", dataType = "String")
    private String imgpath;
    @ApiModelProperty(name = "groupcode", value = "群编码", notes = "群编码", dataType = "String")
    private String groupcode;
}
