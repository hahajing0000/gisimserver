package com.zy.gisim.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "消息类别实体", description = "消息类别实体")
public class MsgTypeEntity {
    @ApiModelProperty(name = "id", value = "id", notes = "id", dataType = "int")
    private int id;
    @ApiModelProperty(name = "msgtypecode", value = "消息类型编码", notes = "消息类型编码", dataType = "int")
    private int msgtypecode;
    @ApiModelProperty(name = "msgtypename", value = "消息类型", notes = "消息类型", dataType = "String")
    private String msgtypename;
}
