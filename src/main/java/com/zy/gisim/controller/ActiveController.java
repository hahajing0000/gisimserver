package com.zy.gisim.controller;

import com.zy.gisim.domain.ReqActiveEntity;
import com.zy.gisim.domain.ReqActiveMemberEntity;
import com.zy.gisim.interceptor.token.UserToken;
import com.zy.gisim.model.ActiveEntity;
import com.zy.gisim.model.ActiveTypeEntity;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.services.ActiveService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/active")
@Api(value = "活动模块API接口", description = "该模块提供活动模块CRUD服务", tags = "活动模块")
public class ActiveController {

    @Autowired
    ActiveService service;

    /**
     * 获取所有活动分类
     * @return
     */
    @UserToken
    @ApiOperation(value = "获取活动类型", notes = "获取活动类型", httpMethod = "GET")
    @GetMapping("/findAllActiveType")
    public ResponseEntity<List<ActiveTypeEntity>> findAllActiveType(){
        return service.findAllActiveType();
    }

    /**
     * 创建活动
     * @param entity
     * @return
     */
    @UserToken
    @ApiOperation(value = "创建活动", notes = "创建活动", httpMethod = "POST")
    @PostMapping("/createActive")
    public ResponseEntity<Boolean> createActive(
            @RequestBody
            @ApiParam(value = "活动请求实体", name = "entity", required = true)
            ReqActiveEntity entity){
        return service.createActive(entity);
    }

    /**
     * 修改活动
     * @param entity
     * @return
     */
    @UserToken
    @ApiOperation(value = "修改活动", notes = "修改活动", httpMethod = "PUT")
    @PutMapping("/modifyActive")
    public ResponseEntity<Boolean> modifyActive(
            @RequestBody
            @ApiParam(value = "活动请求实体", name = "entity", required = true)
            ReqActiveEntity entity){
        return service.modifyActive(entity);
    }

    /**
     * 删除活动
     * @param id
     * @return
     */
    @UserToken
    @ApiOperation(value = "删除活动", notes = "删除活动", httpMethod = "DELETE")
    @DeleteMapping("/removeActive")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "id", value = "活动id", required = true),
    })
    public ResponseEntity<Boolean> removeActive(int id){
        return service.removeActive(id);
    }

    /**
     * 获取用户参见的活动
     * @param userid
     * @return
     */
    @UserToken
    @ApiOperation(value = "获取用户参与的活动信息", notes = "获取用户参与的活动信息", httpMethod = "GET")
    @GetMapping("/findActiveByUser")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true),
    })
    public ResponseEntity<List<ActiveEntity>> findActiveByUser(int userid){
        return service.findActiveByUser(userid);
    }

    /**
     * 添加成员
     * @param entity
     * @return
     */
    @UserToken
    @ApiOperation(value = "添加成员", notes = "添加成员", httpMethod = "POST")
    @PostMapping("/addMember")
    public ResponseEntity<Boolean> addMember(
            @RequestBody
            @ApiParam(value = "成员请求实体", name = "entity", required = true)
            ReqActiveMemberEntity entity){
        return service.addMember(entity);
    }

    /**
     * 删除成员
     * @param activeid
     * @param memberid
     * @return
     */
    @UserToken
    @ApiOperation(value = "删除成员", notes = "删除成员", httpMethod = "DELETE")
    @DeleteMapping("/removeMember")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "activeid", value = "活动id", required = true),
            @ApiImplicitParam(dataType = "int", name = "memberid", value = "成员id", required = true),
    })
    public ResponseEntity<Boolean> removeMember(int activeid,int memberid){
        return service.removeMember(activeid,memberid);
    }

    /**
     * 修改成员昵称
     * @param activeid
     * @param memberid
     * @param nick
     * @return
     */
    @UserToken
    @ApiOperation(value = "修改昵称", notes = "修改昵称", httpMethod = "PUT")
    @PutMapping("/modifyNick")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "activeid", value = "活动id", required = true),
            @ApiImplicitParam(dataType = "int", name = "memberid", value = "成员id", required = true),

            @ApiImplicitParam(dataType = "int", name = "nick", value = "昵称", required = true),
    })
    public ResponseEntity<Boolean> modifyNick(int activeid,int memberid,String nick){
        return service.modifyNick(activeid,memberid,nick);
    }

    /**
     * 同意加入活动
     * @param activeid
     * @param memberid
     * @return
     */
    @UserToken
    @ApiOperation(value = "同意加入活动", notes = "同意加入活动", httpMethod = "PUT")
    @PutMapping("/agree")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "activeid", value = "活动id", required = true),
            @ApiImplicitParam(dataType = "int", name = "memberid", value = "成员id", required = true),
    })
    public ResponseEntity<Boolean> agree(int activeid,int memberid){
        return service.agree(activeid,memberid);
    }

    /**
     * 拒绝加入活动
     * @param activeid
     * @param memberid
     * @return
     */
    @UserToken
    @ApiOperation(value = "拒绝加入活动", notes = "拒绝加入活动", httpMethod = "PUT")
    @PutMapping("/refuse")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "activeid", value = "活动id", required = true),
            @ApiImplicitParam(dataType = "int", name = "memberid", value = "成员id", required = true),
    })
    public ResponseEntity<Boolean> refuse(int activeid,int memberid){
        return service.refuse(activeid,memberid);
    }

    /**
     * 退出活动
     * @param activeid
     * @param memberid
     * @return
     */
    @UserToken
    @ApiOperation(value = "退出活动", notes = "退出活动", httpMethod = "DELETE")
    @DeleteMapping("/quitActive")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "activeid", value = "活动id", required = true),
            @ApiImplicitParam(dataType = "int", name = "memberid", value = "成员id", required = true),
    })
    public ResponseEntity<Boolean> quitActive(int activeid,int memberid){
        return service.quitActive(activeid,memberid);
    }

    /**
     * 是否活动的创建者
     * @param activeid
     * @param memberid
     * @return
     */
    @UserToken
    @ApiOperation(value = "是否活动创建者", notes = "是否活动创建者", httpMethod = "GET")
    @GetMapping("/isOwner")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "activeid", value = "活动id", required = true),
            @ApiImplicitParam(dataType = "int", name = "memberid", value = "成员id", required = true),
    })
    public ResponseEntity<Boolean> isOwner(int activeid,int memberid){
        return service.isOwner(activeid,memberid);
    }
}
