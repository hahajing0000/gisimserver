package com.zy.gisim.services;

import com.zy.gisim.domain.ReqFriendEntity;
import com.zy.gisim.model.FriendEntity;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.model.UserEntity;

import java.util.List;

public interface FriendService {
    /**
     * 添加好友
     * @param entity
     * @return
     */
    ResponseEntity<Boolean> addFriend(ReqFriendEntity entity);

    /**
     * 删除好友
     * @param userid
     * @param friendid
     * @return
     */
    ResponseEntity<Boolean> deleteFriend(int userid,int friendid);

    /**
     * 修改备注名称
     * @param userid
     * @param friendid
     * @param alias
     * @return
     */
    ResponseEntity<Boolean> modifyAlias(int userid,int friendid,String alias);

    /**
     * 更换本地分组
     * @param userid
     * @param friendid
     * @param groupid
     * @return
     */
    ResponseEntity<Boolean> changeLocalGroup(int userid,int friendid,int groupid);

    /**
     * 获取好友列表
     * @param userid
     * @return
     */
    ResponseEntity<List<FriendEntity>> findByUserid(int userid);

    /**
     * 根据用户id 分组id获取指定分组下的好友信息
     * @param userid
     * @param groupid
     * @return
     */
    ResponseEntity<List<FriendEntity>> findByUseridGroupid(int userid,int groupid);

    /**
     * 获取好友信息
     * @param userid
     * @param friendid
     * @return
     */
    ResponseEntity<FriendEntity> findById(int userid,int friendid);

    /**
     * 同意加好友
     * @param userid
     * @param friendid
     * @return
     */
    ResponseEntity<Boolean> agree(int userid,int friendid);

    /**
     * 拒绝加好友
     * @param userid
     * @param friendid
     * @return
     */
    ResponseEntity<Boolean> refuse(int userid,int friendid);

    /**
     * 获取所有添加好友请求
     * @param userid
     * @return
     */
    ResponseEntity<List<FriendEntity>> findReqFriends(int userid);

    /**
     * 按手机号或者昵称查找用户
     * @param keyword
     * @return
     */
    ResponseEntity<List<UserEntity>> queryUser(String keyword);
}
