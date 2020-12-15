package com.zy.gisim.controller;

import com.zy.gisim.domain.ReqFriendEntity;
import com.zy.gisim.interceptor.token.UserToken;
import com.zy.gisim.model.FriendEntity;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.model.UserEntity;
import com.zy.gisim.services.FriendService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friend")
@Api(value = "好友模块API接口", description = "该模块提供好友模块CRUD服务", tags = "好友模块")
public class FriendController {

    @Autowired
    FriendService service;

    /**
     * 添加好友
     * @param entity
     * @return
     */
    @UserToken
    @ApiOperation(value = "添加好友", notes = "添加好友", httpMethod = "POST")
    @PostMapping("/addFriend")
    public ResponseEntity<Boolean> addFriend(
            @RequestBody
            @ApiParam(value = "好友请求实体", name = "entity", required = true)
            ReqFriendEntity entity){
        return service.addFriend(entity);
    }

    /**
     * 删除好友
     * @param userid
     * @param friendid
     * @return
     */
    @UserToken
    @ApiOperation(value = "删除好友", notes = "删除好友", httpMethod = "DELETE")
    @DeleteMapping("/deleteFriend")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "int", name = "friendid", value = "好友id", required = true)
    })
    public ResponseEntity<Boolean> deleteFriend(int userid,int friendid){
        return service.deleteFriend(userid,friendid);
    }

    /**
     * 修改备注名称
     * @param userid
     * @param friendid
     * @param alias
     * @return
     */
    @UserToken
    @ApiOperation(value = "修改好友备注名称", notes = "修改好友备注名称", httpMethod = "PUT")
    @PutMapping("/modifyAlias")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "int", name = "friendid", value = "好友id", required = true),
            @ApiImplicitParam(dataType = "String", name = "alias", value = "备注名称", required = true),
    })
    public ResponseEntity<Boolean> modifyAlias(int userid,int friendid,String alias){
        return service.modifyAlias(userid,friendid,alias);
    }

    /**
     * 更换本地分组
     * @param userid
     * @param friendid
     * @param groupid
     * @return
     */
    @UserToken
    @ApiOperation(value = "更换本地分组", notes = "更换本地分组", httpMethod = "PUT")
    @PutMapping("/changeLocalGroup")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "int", name = "friendid", value = "好友id", required = true),
            @ApiImplicitParam(dataType = "int", name = "groupid", value = "本地分组id", required = true),
    })
    public ResponseEntity<Boolean> changeLocalGroup(int userid,int friendid,int groupid){
        return service.changeLocalGroup(userid,friendid,groupid);
    }

    /**
     * 获取好友列表
     * @param userid
     * @return
     */
    @UserToken
    @ApiOperation(value = "根据用户id获取好友列表", notes = "根据用户id获取好友列表", httpMethod = "GET")
    @GetMapping("/findByUserid")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true),
    })
    public ResponseEntity<List<FriendEntity>> findByUserid(int userid){
        return service.findByUserid(userid);
    }

    /**
     * 根据用户id 分组id获取指定分组下的好友信息
     * @param userid
     * @param groupid
     * @return
     */
    @UserToken
    @ApiOperation(value = "获取用户本地分组下的好友列表", notes = "获取用户本地分组下的好友列表", httpMethod = "GET")
    @GetMapping("/findByUseridGroupid")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "int", name = "groupid", value = "本地分组id", required = true),
    })
    public ResponseEntity<List<FriendEntity>> findByUseridGroupid(int userid,int groupid){
        return service.findByUseridGroupid(userid,groupid);
    }

    /**
     * 获取好友信息
     * @param userid
     * @param friendid
     * @return
     */
    @UserToken
    @ApiOperation(value = "获取好友信息", notes = "获取好友信息", httpMethod = "GET")
    @GetMapping("/findById")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "int", name = "friendid", value = "好友id", required = true),
    })
    public ResponseEntity<FriendEntity> findById(int userid,int friendid){
        return service.findById(userid,friendid);
    }

    /**
     * 同意加好友
     * @param userid
     * @param friendid
     * @return
     */
    @UserToken
    @ApiOperation(value = "同意添加好友", notes = "同意添加好友", httpMethod = "PUT")
    @PutMapping("/agree")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "int", name = "friendid", value = "好友id", required = true),
    })
    public ResponseEntity<Boolean> agree(int userid,int friendid){
        return service.agree(userid,friendid);
    }

    /**
     * 拒绝加好友
     * @param userid
     * @param friendid
     * @return
     */
    @UserToken
    @ApiOperation(value = "拒绝添加好友", notes = "拒绝添加好友", httpMethod = "PUT")
    @PutMapping("/refuse")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "int", name = "friendid", value = "好友id", required = true),
    })
    public ResponseEntity<Boolean> refuse(int userid,int friendid){
        return service.refuse(userid,friendid);
    }

    /**
     * 获取所有添加好友请求
     * @param userid
     * @return
     */
    @UserToken
    @ApiOperation(value = "获取添加好友申请", notes = "获取添加好友申请", httpMethod = "GET")
    @GetMapping("/findReqFriends")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true)
    })
    public ResponseEntity<List<FriendEntity>> findReqFriends(int userid){
        return service.findReqFriends(userid);
    }

    /**
     * 按手机号或者昵称查找用户
     * @param keyword
     * @return
     */
    @UserToken
    @ApiOperation(value = "根据电话号码或者昵称获取用户信息", notes = "根据电话号码或者昵称获取用户信息", httpMethod = "GET")
    @GetMapping("/queryUser")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "String", name = "keyword", value = "搜索关键字", required = true)
    })
    public ResponseEntity<List<UserEntity>> queryUser(String keyword){
        return service.queryUser(keyword);
    }
}
