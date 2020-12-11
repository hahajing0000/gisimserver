package com.zy.gisim.controller;

import com.zy.gisim.domain.ReqReqisterUserEntity;
import com.zy.gisim.interceptor.token.UserToken;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.model.UserEntity;
import com.zy.gisim.services.TokenService;
import com.zy.gisim.services.UserService;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(value = "用户模块API接口", description = "该模块提供用户注册登录等服务", tags = "用户模块")
public class UserController {
    @Autowired
    UserService service;

    @Autowired
    TokenService tokenService;

    /**
     * 注册用户
     * @param entity
     * @return
     */
    @ApiOperation(value = "注册", notes = "注册", httpMethod = "POST")
    @PostMapping("/register")
    public ResponseEntity<Boolean> register(
            @RequestBody
            @ApiParam(value = "用户请求实体", name = "entity", required = true)
            ReqReqisterUserEntity entity){
        return service.register(entity);
    }

    /**
     * 用户登录
     * @param entity
     * @return
     */
    @ApiOperation(value = "登录", notes = "登录", httpMethod = "POST")
    @PostMapping("/login")
    public ResponseEntity<UserEntity> login(
            @RequestBody
            @ApiParam(value = "用户请求实体", name = "entity", required = true)
            ReqReqisterUserEntity entity){
        ResponseEntity<UserEntity> result = service.login(entity);
        if (result!=null&&result.getData()!=null&&result.getCode()>=0){
            String userToken = tokenService.getUserToken(result.getData());
            result.getData().setToken(userToken);
        }
        return result;
    }

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @UserToken
    @ApiOperation(value = "根据id获取用户信息", notes = "根据id获取用户信息", httpMethod = "GET")
    @GetMapping("/getUserById")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "id", value = "用户id", required = true)
    })
    public ResponseEntity<UserEntity> getUserById(int id){
        return service.getUserById(id);
    }

    /**
     * 修改密码
     * @param id 用户id
     * @param pwd 修改的密码
     * @return
     */
    @UserToken
    @ApiOperation(value = "修改密码", notes = "修改密码", httpMethod = "PUT")
    @PutMapping("/modifyPwd")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "id", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "String", name = "pwd", value = "密码", required = true),
    })
    public ResponseEntity<Boolean> modifyPwd(int id,String pwd){
        return service.modifyPwd(id,pwd);
    }

    /**
     * 修改用户信息
     * @param nick 昵称头像
     * @param id 用户id
     * @return
     */
    @UserToken
    @ApiOperation(value = "修改昵称", notes = "修改昵称", httpMethod = "PUT")
    @PutMapping("/modifyNick")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "id", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "String", name = "nick", value = "昵称", required = true),
    })
    public ResponseEntity<Boolean> modifyNick(int id,String nick){
        return service.modifyNick(id,nick);
    }

    /**
     * 修改头像
     * @param id 用户id
     * @param headimg 头像
     * @return
     */
    @UserToken
    @ApiOperation(value = "修改头像", notes = "修改头像", httpMethod = "PUT")
    @PutMapping("/modifyHeadimg")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "id", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "String", name = "headimg", value = "头像", required = true),
    })
    public ResponseEntity<Boolean> modifyHeadimg(int id,String headimg){
        return service.modifyHeadimg(id,headimg);
    }

    /**
     * 修改用户位置
     * @param id 用户id
     * @param lat 纬度
     * @param lon 经度
     * @return
     */
    @UserToken
    @ApiOperation(value = "上传位置", notes = "上传位置", httpMethod = "PUT")
    @PutMapping("/uploadLocation")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "int", name = "id", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "double", name = "lon", value = "经度", required = true),
            @ApiImplicitParam(dataType = "double", name = "lat", value = "纬度", required = true),
    })
    public ResponseEntity<Boolean> uploadLocation(int id,double lon,double lat){
        return service.uploadLocation(id,lon,lat);
    }

    /**
     * 获取验证码
     * @param phoneNumber 手机号码
     * @return
     */
    @ApiOperation(value = "获取验证码", notes = "获取验证码", httpMethod = "GET")
    @GetMapping("/verificationCode")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(dataType = "String", name = "phoneNumber", value = "手机号码", required = true),
    })
    public ResponseEntity<String> verificationCode(String phoneNumber){
        return service.verificationCode(phoneNumber);
    }
}
