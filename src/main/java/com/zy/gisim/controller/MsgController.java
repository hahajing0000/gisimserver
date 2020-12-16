package com.zy.gisim.controller;

import com.zy.gisim.domain.ReqMsgEntity;
import com.zy.gisim.interceptor.token.UserToken;
import com.zy.gisim.model.MsgEntity;
import com.zy.gisim.model.MsgTypeEntity;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.services.MsgService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/msg")
@Api(value = "消息模块API接口", description = "该模块提供消息CRUD服务", tags = "消息模块")
public class MsgController {

    @Autowired
    MsgService service;

    /**
     * 获取所有消息分类
     * @return
     */
    @UserToken
    @ApiOperation(value = "获取消息分类", notes = "获取消息分类", httpMethod = "GET")
    @GetMapping("/findAllMsgTypes")
    public ResponseEntity<List<MsgTypeEntity>> findAllMsgTypes(){
        return service.findAllMsgTypes();
    }

    /**
     * 发送消息
     * @param entity
     * @return
     */
    @UserToken
    @ApiOperation(value = "发送消息", notes = "发送消息", httpMethod = "POST")
    @PostMapping("/sendMsg")
    public ResponseEntity<Boolean> sendMsg(
            @RequestBody
            @ApiParam(value = "消息请求实体", name = "entity", required = true)
            ReqMsgEntity entity){
        return service.sendMsg(entity);
    }

    /**
     * 接收消息
     * @param entity
     * @return
     */
    @UserToken
    @ApiOperation(value = "接收消息", notes = "接收消息", httpMethod = "POST")
    @PostMapping("/receiveMsg")
    public ResponseEntity<Boolean> receiveMsg(
            @RequestBody
            @ApiParam(value = "消息请求实体", name = "entity", required = true)
            ReqMsgEntity entity){
        return service.receiveMsg(entity);
    }

    /**
     * 删除指定消息
     * @param id
     * @return
     */
    @UserToken
    @ApiOperation(value = "删除消息", notes = "删除消息", httpMethod = "DELETE")
    @DeleteMapping("/removeMsg")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "id", value = "消息id", required = true)
    })
    public ResponseEntity<Boolean> removeMsg(int id){
        return service.removeMsg(id);
    }

    /**
     * 标记消息已读
     * @param ids
     * @return
     */
    @UserToken
    @ApiOperation(value = "修改消息状态为已读", notes = "修改消息状态为已读", httpMethod = "PUT")
    @PutMapping("/readMsg")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "List<Integer>", name = "ids", value = "id集合", required = true)
    })
    public ResponseEntity<Boolean> readMsg(List<Integer> ids){
        return service.readMsg(ids);
    }

    /**
     * 获取与指定用户的聊天记录
     * @param userid 当前用户
     * @param friendid 指定用户
     * @return
     */
    @UserToken
    @ApiOperation(value = "获取与指定用户的聊天记录", notes = "获取与指定用户的聊天记录", httpMethod = "GET")
    @GetMapping("/findMsgsByUser")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "int", name = "friendid", value = "好友id", required = true),
            @ApiImplicitParam(dataType = "int", name = "page", value = "当前页数", required = true),
            @ApiImplicitParam(dataType = "int", name = "pagesize", value = "每页数据数", required = true),
    })
    public ResponseEntity<List<MsgEntity>> findMsgsByUser(int userid, int friendid,int page,int pagesize){
        return service.findMsgsByUser(userid,friendid,page,pagesize);
    }
}
