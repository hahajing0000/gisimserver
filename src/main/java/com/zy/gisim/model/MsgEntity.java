package com.zy.gisim.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "消息实体", description = "消息实体")
public class MsgEntity {
    @ApiModelProperty(name = "id", value = "id", notes = "id", dataType = "int")
    private int id;
    @ApiModelProperty(name = "content", value = "消息内容", notes = "消息内容", dataType = "String")
    private String content;
    @ApiModelProperty(name = "fromuser", value = "发送用户", notes = "发送用户", dataType = "int")
    private int fromuser;
    @ApiModelProperty(name = "touser", value = "接收用户", notes = "接收用户", dataType = "int")
    private int touser;
    @ApiModelProperty(name = "msgtypeid", value = "消息类型", notes = "消息类型", dataType = "int")
    private int msgtypeid;
    @ApiModelProperty(name = "msgtype2", value = "0-发送消息 1-接收消息", notes = "0-发送消息 1-接收消息", dataType = "int")
    private int msgtype2;
    @ApiModelProperty(name = "isread", value = "是否读取 0-未读 1-已读", notes = "是否读取 0-未读 1-已读", dataType = "int")
    private int isread;
    @ApiModelProperty(name = "ctime", value = "创建时间", notes = "创建时间", dataType = "String")
    private String ctime;
    @ApiModelProperty(name = "blltime", value = "发送或者接收时间", notes = "发送或者接收时间", dataType = "String")
    private String blltime;
}
