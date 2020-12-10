package com.zy.gisim.services;

import com.zy.gisim.domain.ReqReqisterUserEntity;
import com.zy.gisim.model.UserEntity;

public interface UserService {
    /**
     * 注册用户
     * @param entity
     * @return
     */
    boolean register(ReqReqisterUserEntity entity);

    /**
     * 用户登录
     * @param entity
     * @return
     */
    boolean login(ReqReqisterUserEntity entity);

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    UserEntity getUserById(int id);

    /**
     * 修改密码
     * @param id 用户id
     * @param pwd 修改的密码
     * @return
     */
    boolean modifyPwd(int id,String pwd);

    /**
     * 修改用户信息
     * @param nick 昵称头像
     * @param id 用户id
     * @return
     */
    boolean modifyNick(int id,String nick);

    /**
     * 修改头像
     * @param id 用户id
     * @param headimg 头像
     * @return
     */
    boolean modifyHeadimg(int id,String headimg);

    /**
     * 修改用户位置
     * @param id 用户id
     * @param lat 纬度
     * @param lon 经度
     * @return
     */
    boolean uploadLocation(int id,double lat,double lon);
}
