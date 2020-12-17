package com.zy.gisim.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "活动实体", description = "活动实体")
public class ActiveEntity {
    @ApiModelProperty(name = "id", value = "id", notes = "id", dataType = "int")
    private int id;
    @ApiModelProperty(name = "activetypeid", value = "活动类型id", notes = "活动类型id", dataType = "int")
    private int activetypeid;
    @ApiModelProperty(name = "activename", value = "活动名称", notes = "活动名称", dataType = "String")
    private String activename;
    @ApiModelProperty(name = "lon", value = "活动地点经度", notes = "活动地点经度", dataType = "double")
    private double lon;
    @ApiModelProperty(name = "lat", value = "活动地点纬度", notes = "活动地点纬度", dataType = "double")
    private double lat;
    @ApiModelProperty(name = "locationname", value = "位置名称", notes = "位置名称", dataType = "String")
    private String locationname;
    @ApiModelProperty(name = "starttime", value = "活动开始时间", notes = "活动开始时间", dataType = "String")
    private String starttime;
    @ApiModelProperty(name = "activedesc", value = "活动描述", notes = "活动描述", dataType = "String")
    private String activedesc;
    @ApiModelProperty(name = "owner", value = "活动创建者", notes = "活动创建者", dataType = "String")
    private String owner;
}
