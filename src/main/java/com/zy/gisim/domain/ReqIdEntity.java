package com.zy.gisim.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "id请求实体", description = "id请求实体")
public class ReqIdEntity {
    @ApiModelProperty(name = "id", value = "id", notes = "id", dataType = "int")
    private int id;
}
