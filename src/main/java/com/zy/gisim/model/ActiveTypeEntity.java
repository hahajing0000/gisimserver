package com.zy.gisim.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "活动类型实体", description = "活动类型实体")
public class ActiveTypeEntity {
    @ApiModelProperty(name = "id", value = "id", notes = "id", dataType = "int")
    private int id;
    @ApiModelProperty(name = "activetypename", value = "活动类型名称", notes = "活动类型名称", dataType = "String")
    private String activetypename;
    @ApiModelProperty(name = "imgpath", value = "图片地址", notes = "图片地址", dataType = "String")
    private String imgpath;
}
