package com.zy.gisim.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "群组消息请求实体", description = "群组消息请求实体")
public class ReqGroupMsgEntity extends ReqMsgEntity {
    @ApiModelProperty(name = "groupid", value = "群组id", notes = "群组id", dataType = "int")
    private int groupid;
}
