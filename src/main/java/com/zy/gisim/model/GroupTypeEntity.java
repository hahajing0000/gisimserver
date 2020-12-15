package com.zy.gisim.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "群组类型实体", description = "群组类型实体")
public class GroupTypeEntity {
    @ApiModelProperty(name = "id", value = "id", notes = "id", dataType = "int")
    private int id;
    @ApiModelProperty(name = "typename", value = "类型名称", notes = "类型名称", dataType = "String")
    private String typename;
}
