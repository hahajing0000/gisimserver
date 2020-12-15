package com.zy.gisim.controller;

import com.zy.gisim.domain.ReqGroupEntity;
import com.zy.gisim.domain.ReqGroupMemberEntity;
import com.zy.gisim.interceptor.token.UserToken;
import com.zy.gisim.model.GroupEntity;
import com.zy.gisim.model.GroupMemberEntity;
import com.zy.gisim.model.GroupTypeEntity;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.services.GroupService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@Api(value = "群组模块API接口", description = "该模块提供群组模块CRUD服务", tags = "群组模块")
public class GroupControlloer {
    @Autowired
    GroupService service;

    /**
     * 获取所有群组类型
     * @return
     */
    @UserToken
    @ApiOperation(value = "添加好友", notes = "添加好友", httpMethod = "GET")
    @GetMapping("/findAllTypes")
    public ResponseEntity<List<GroupTypeEntity>> findAllTypes(){
        return service.findAllTypes();
    }

    /**
     * 创建分组
     * @param entity
     * @return
     */
    @UserToken
    @ApiOperation(value = "创建分组", notes = "创建分组", httpMethod = "POST")
    @PostMapping("/createGroup")
    public ResponseEntity<Boolean> createGroup(
            @RequestBody
            @ApiParam(value = "群组请求实体", name = "entity", required = true)
            ReqGroupEntity entity){
        return service.createGroup(entity);
    }

    /**
     * 修改分组
     * @param entity
     * @return
     */
    @UserToken
    @ApiOperation(value = "修改群组", notes = "修改群组", httpMethod = "PUT")
    @PutMapping("/modifyGroup")
    public ResponseEntity<Boolean> modifyGroup(
            @RequestBody
            @ApiParam(value = "群组请求实体", name = "entity", required = true)
            ReqGroupEntity entity){
        return service.modifyGroup(entity);
    }

    /**
     * 删除分组
     * @param id
     * @return
     */
    @UserToken
    @ApiOperation(value = "删除群组", notes = "删除群组", httpMethod = "DELETE")
    @DeleteMapping("/deleteGroup")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "id", value = "群组id", required = true),
    })
    public ResponseEntity<Boolean> deleteGroup(int id){
        return service.deleteGroup(id);
    }

    /**
     * 获取指定用户创建的所有分组
     * @param userid
     * @return
     */
    @UserToken
    @ApiOperation(value = "获取指定用户创建的所有分组", notes = "获取指定用户创建的所有分组", httpMethod = "GET")
    @GetMapping("/findByOwnerId")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true),
    })
    public ResponseEntity<List<GroupEntity>> findByOwnerId(int userid){
        return service.findByOwnerId(userid);
    }

    /**
     * 获取用户加入的分组
     * @param usreid
     * @return
     */
    @UserToken
    @ApiOperation(value = "获取用户加入的分组", notes = "获取用户加入的分组", httpMethod = "GET")
    @GetMapping("/findByUserJoinGroups")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true),
    })
    public ResponseEntity<List<GroupEntity>> findByUserJoinGroups(int usreid){
        return service.findByUserJoinGroups(usreid);
    }

    /**
     * 根据关键字查询在组编码及组名称包含关键字的群组信息
     * @param keyword
     * @return
     */
    @UserToken
    @ApiOperation(value = "根据关键字查询在组编码及组名称包含关键字的群组信息", notes = "根据关键字查询在组编码及组名称包含关键字的群组信息", httpMethod = "GET")
    @GetMapping("/queryByKeyword")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "String", name = "keyword", value = "关键字", required = true),
    })
    public ResponseEntity<List<GroupEntity>> queryByKeyword(String keyword){
        return service.queryByKeyword(keyword);
    }

    /**
     * 加入群组
     * @param entity
     * @return
     */
    @UserToken
    @ApiOperation(value = "加入群组", notes = "加入群组", httpMethod = "POST")
    @PostMapping("/joinGroup")
    public ResponseEntity<Boolean> joinGroup(
            @RequestBody
            @ApiParam(value = "群组成员请求实体", name = "entity", required = true)
            ReqGroupMemberEntity entity){
        return service.joinGroup(entity);
    }

    /**
     * 删除成员
     * @param id
     * @return
     */
    @UserToken
    @ApiOperation(value = "删除成员", notes = "删除成员", httpMethod = "DELETE")
    @DeleteMapping("/removeMember")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "id", value = "群成员id", required = true),
    })
    public ResponseEntity<Boolean> removeMember(int id){
        return service.removeMember(id);
    }

    /**
     * 修改昵称
     * @param id
     * @param nick
     * @return
     */
    @UserToken
    @ApiOperation(value = "修改昵称", notes = "修改昵称", httpMethod = "PUT")
    @PutMapping("/modifyNick")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "id", value = "群成员id", required = true),
            @ApiImplicitParam(dataType = "String", name = "nick", value = "昵称", required = true),
    })
    public ResponseEntity<Boolean> modifyNick(int id,String nick){
        return service.modifyNick(id,nick);
    }

    /**
     * 申请成为管理员
     * @param id
     * @return
     */
    @UserToken
    @ApiOperation(value = "申请成为管理员", notes = "申请成为管理员", httpMethod = "PUT")
    @PutMapping("/requestAdmin")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "id", value = "群成员id", required = true),
    })
    public ResponseEntity<Boolean> requestAdmin(int id){
        return service.requestAdmin(id);
    }

    /**
     * 修改成员进群状态 状态 0-邀请进群 1-申请进群 2-同意进群|已进群 3-拒绝进群
     * @param id
     * @param status
     * @return
     */
    @UserToken
    @ApiOperation(value = "修改成员进群状态", notes = "修改成员进群状态", httpMethod = "PUT")
    @PutMapping("/modifyStatus")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "id", value = "群成员id", required = true),
            @ApiImplicitParam(dataType = "int", name = "status", value = "状态 0-邀请进群 1-申请进群 2-同意进群|已进群 3-拒绝进群", required = true),
    })
    public ResponseEntity<Boolean> modifyStatus(int id,int status){
        return service.modifyStatus(id,status);
    }

    /**
     * 获取指定分组下的成员列表
     * @param groupid
     * @return
     */
    @UserToken
    @ApiOperation(value = "获取指定分组下的成员列表", notes = "获取指定分组下的成员列表", httpMethod = "GET")
    @GetMapping("/findByGroupId")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "groupid", value = "群组id", required = true),
    })
    public ResponseEntity<List<GroupMemberEntity>> findByGroupId(int groupid){
        return service.findByGroupId(groupid);
    }

    /**
     * 退群
     * @param groupid
     * @param userid
     * @return
     */
    @UserToken
    @ApiOperation(value = "退群", notes = "退群", httpMethod = "DELETE")
    @GetMapping("/quitGroup")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "groupid", value = "群组id", required = true),
            @ApiImplicitParam(dataType = "int", name = "userid", value = "用户id", required = true),
    })
    public ResponseEntity<Boolean> quitGroup(int groupid,int userid){
        return service.quitGroup(groupid,userid);
    }
}
