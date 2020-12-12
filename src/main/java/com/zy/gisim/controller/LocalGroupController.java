package com.zy.gisim.controller;

import com.zy.gisim.domain.ReqLocalGroupEntity;
import com.zy.gisim.interceptor.token.UserToken;
import com.zy.gisim.model.LocalGroupEntity;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.services.LocalGroupService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localgroup")
@Api(value = "本地分组模块API接口", description = "该模块提供本地分组CRUD服务", tags = "本地分组模块")
public class LocalGroupController {
    @Autowired
    LocalGroupService service;

    /**
     * 创建本地分组
     * @param entity
     * @return
     */
    @UserToken
    @ApiOperation(value = "创建本地分组", notes = "创建本地分组", httpMethod = "POST")
    @PostMapping("/createLocalGroup")
    public ResponseEntity<Boolean> createLocalGroup(
            @RequestBody
            @ApiParam(value = "本地分组请求实体", name = "entity", required = true)
            ReqLocalGroupEntity entity){
        return service.createLocalGroup(entity);
    }

    /**
     * 删除本地分组
     * @param groupid
     * @return
     */
    @UserToken
    @ApiOperation(value = "删除本地分组", notes = "删除本地分组", httpMethod = "DELETE")
    @DeleteMapping("/deleteLocalGroup")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "groupid", value = "本地分组id", required = true)
    })
    public ResponseEntity<Boolean> deleteLocalGroup(int groupid){
        return service.deleteLocalGroup(groupid);
    }

    /**
     * 修改本地分组
     * @param entity
     * @return
     */
    @UserToken
    @ApiOperation(value = "修改本地分组信息", notes = "修改本地分组信息", httpMethod = "PUT")
    @PutMapping("/modifyLocalGroup")
    public ResponseEntity<Boolean> modifyLocalGroup(
            @RequestBody
            @ApiParam(value = "本地分组请求实体", name = "entity", required = true)
            ReqLocalGroupEntity entity){
        return service.modifyLocalGroup(entity);
    }

    /**
     * 获取指定用户的本地分组
     * @param userid
     * @return
     */
    @UserToken
    @ApiOperation(value = "根据userid获取本地分组信息", notes = "根据userid获取本地分组信息", httpMethod = "GET")
    @GetMapping("/findByUserId")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true)
    })
    public ResponseEntity<List<LocalGroupEntity>> findByUserId(int userid){
        return service.findByUserId(userid);
    }

    /**
     * 根据id获取分组信息
     * @param groupid
     * @return
     */
    @UserToken
    @ApiOperation(value = "根据id获取本地分组信息", notes = "根据id获取本地分组信息", httpMethod = "GET")
    @GetMapping("/findById")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "groupid", value = "本地分组id", required = true)
    })
    public ResponseEntity<LocalGroupEntity> findById(int groupid){
        return service.findById(groupid);
    }


    /**
     * 修改成员数量
     * @param groupid 分组id
     * @param relativeCount 相对数
     * @return
     */
    @UserToken
    @ApiOperation(value = "修改本地分组成员数量", notes = "修改本地分组成员数量", httpMethod = "PUT")
    @PutMapping("/modifyMemberCount")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "groupid", value = "本地分组id", required = true),
            @ApiImplicitParam(dataType = "int", name = "relativeCount", value = "相对数量 增加即累计  存入负数即递减", required = true),
    })
    public ResponseEntity<Boolean> modifyMemberCount(int groupid,int relativeCount){
        return service.modifyMemberCount(groupid,relativeCount);
    }
}
