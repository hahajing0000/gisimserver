package com.zy.gisim.services.impl;

import com.zy.gisim.domain.ReqReqisterUserEntity;
import com.zy.gisim.mapper.UserMapper;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.model.UserEntity;
import com.zy.gisim.services.UserService;
import com.zy.gisim.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;


    @Override
    public ResponseEntity<Boolean> register(ReqReqisterUserEntity entity) {
        boolean result = mapper.register(entity);
        if (result){
            return ResponseUtils.success(result);
        }
        return ResponseUtils.failed("用户注册失败");
    }

    @Override
    public ResponseEntity<UserEntity> login(ReqReqisterUserEntity entity) {
        UserEntity result = mapper.login(entity);
        if (result==null){
            return ResponseUtils.failed("用户名或者密码不正确");
        }
        return ResponseUtils.success(result);
    }

    @Override
    public ResponseEntity<UserEntity> getUserById(int id) {
        UserEntity result = mapper.getUserById(id);
        if (result==null){
            return ResponseUtils.failed("没有查找到该用户");
        }
        return ResponseUtils.success(result);
    }

    @Override
    public ResponseEntity<Boolean> modifyPwd(int id, String pwd) {
        boolean result = mapper.modifyPwd(id, pwd);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("修改密码失败");
    }

    @Override
    public ResponseEntity<Boolean> modifyNick(int id, String nick) {
        boolean result = mapper.modifyNick(id, nick);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("修改昵称失败");
    }

    @Override
    public ResponseEntity<Boolean> modifyHeadimg(int id, String headimg) {
        boolean result = mapper.modifyHeadimg(id, headimg);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("修改头像失败");
    }

    @Override
    public ResponseEntity<Boolean> uploadLocation(int id, double lon, double lat) {
        boolean result = mapper.uploadLocation(id,lon,lat);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("上传位置信息");
    }
}
