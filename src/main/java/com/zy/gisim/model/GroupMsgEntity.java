package com.zy.gisim.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "群组消息实体", description = "群组消息实体")
public class GroupMsgEntity extends MsgEntity {
    @ApiModelProperty(name = "id", value = "id", notes = "id", dataType = "int")
    private int id;
    @ApiModelProperty(name = "groupid", value = "群组id", notes = "群组id", dataType = "int")
    private int groupid;
}
