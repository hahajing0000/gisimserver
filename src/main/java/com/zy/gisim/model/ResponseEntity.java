package com.zy.gisim.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "基础响应实体", description = "基础响应实体")
@Data
public class ResponseEntity<T> {
    @ApiModelProperty(value = "结果码")
    private Integer code;
    @ApiModelProperty(value = "结果消息")
    private String msg;
    @ApiModelProperty(value = "结果数据")
    private T data;
}