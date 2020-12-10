package com.zy.gisim.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "注册用户实体", description = "注册用户实体")
public class ReqReqisterUserEntity {
    @ApiModelProperty(name = "phonenumber", value = "电话号码", notes = "电话号码", dataType = "String")
    private String phonenumber;
    @ApiModelProperty(name = "pwd", value = "登录密码", notes = "登录密码", dataType = "String")
    private String pwd;
}
