package com.zy.gisim.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "用户实体", description = "用户实体")
public class UserEntity {
    @ApiModelProperty(name = "id", value = "id", notes = "id", dataType = "int")
    private int id;
    @ApiModelProperty(name = "phonenumber", value = "电话号码", notes = "电话号码", dataType = "String")
    private String phonenumber;
    @ApiModelProperty(name = "nick", value = "昵称", notes = "昵称", dataType = "String")
    private String nick;
    @ApiModelProperty(name = "headimg", value = "头像地址", notes = "头像地址", dataType = "String")
    private String headimg;
    @ApiModelProperty(name = "imaccount", value = "IM系统关联账户", notes = "IM系统关联账户", dataType = "String")
    private String imaccount;
    @ApiModelProperty(name = "token", value = "token", notes = "token", dataType = "String")
    private String token;

}
