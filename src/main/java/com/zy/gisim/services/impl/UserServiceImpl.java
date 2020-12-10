package com.zy.gisim.services.impl;

import com.zy.gisim.domain.ReqReqisterUserEntity;
import com.zy.gisim.mapper.UserMapper;
import com.zy.gisim.model.UserEntity;
import com.zy.gisim.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    @Override
    public boolean register(ReqReqisterUserEntity entity) {
        return false;
    }

    @Override
    public boolean login(ReqReqisterUserEntity entity) {
        return false;
    }

    @Override
    public UserEntity getUserById(int id) {
        return null;
    }

    @Override
    public boolean modifyPwd(int id, String pwd) {
        return false;
    }

    @Override
    public boolean modifyNick(int id, String nick) {
        return false;
    }

    @Override
    public boolean modifyHeadimg(int id, String headimg) {
        return false;
    }

    @Override
    public boolean uploadLocation(int id, double lat, double lon) {
        return false;
    }
}
