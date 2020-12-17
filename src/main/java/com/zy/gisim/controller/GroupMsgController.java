package com.zy.gisim.controller;

import com.zy.gisim.domain.ReqGroupMsgEntity;
import com.zy.gisim.domain.ReqIdEntity;
import com.zy.gisim.interceptor.token.UserToken;
import com.zy.gisim.model.GroupMsgEntity;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.services.GroupMsgService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupmsg")
@Api(value = "群组消息模块API接口", description = "该模块提供群组消息模块CRUD服务", tags = "群组消息模块")
public class GroupMsgController {
    @Autowired
    GroupMsgService service;

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
            @ApiParam(value = "群组消息请求实体", name = "entity", required = true)
            ReqGroupMsgEntity entity){
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
            @ApiParam(value = "群组消息请求实体", name = "entity", required = true)
            ReqGroupMsgEntity entity){
        return service.receiveMsg(entity);
    }

    /**
     * 删除指定消息
     * @param id
     * @return
     */
    @UserToken
    @ApiOperation(value = "删除群组消息", notes = "删除群组消息", httpMethod = "DELETE")
    @DeleteMapping("/removeMsg")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "id", value = "群组消息id", required = true),
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
//    @ApiImplicitParams(value = {
//            @ApiImplicitParam(dataType = "int[]", name = "ids", value = "群组消息ids", required = true),
//    })
    public ResponseEntity<Boolean> readMsg(
            @RequestBody
            @ApiParam(value = "群组消息ids", name = "ids", required = true)
            List<ReqIdEntity> ids){
        return service.readMsg(ids);
    }

    /**
     * 获取与指定用户的聊天记录
     * @param userid 当前用户
     * @param groupid 群组id
     * @return
     */
    @UserToken
    @ApiOperation(value = "获取群组消息", notes = "获取群组消息", httpMethod = "GET")
    @GetMapping("/findGroupMsgs")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "int", name = "groupid", value = "群组id", required = true),
            @ApiImplicitParam(dataType = "int", name = "page", value = "当前页数", required = true),
            @ApiImplicitParam(dataType = "int", name = "pagesize", value = "每页数据数", required = true),
    })
    public ResponseEntity<List<GroupMsgEntity>> findGroupMsgs(int userid, int groupid, int page, int pagesize){
        return service.findGroupMsgByUser(userid,groupid,page,pagesize);
    }
}
