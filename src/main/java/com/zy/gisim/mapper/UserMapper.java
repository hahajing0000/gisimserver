package com.zy.gisim.mapper;

import com.zy.gisim.domain.ReqReqisterUserEntity;
import com.zy.gisim.model.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
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
    UserEntity login(ReqReqisterUserEntity entity);

    /**
     * 判断用户是否存在
     * @param phonenumber 电话号码
     * @return
     */
    int existsUser(String phonenumber);

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
     * @param id
     * @param lon
     * @param lat
     * @return
     */
    boolean uploadLocation(int id,double lon,double lat);
}
