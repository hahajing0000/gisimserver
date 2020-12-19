package com.zy.gisim.services;

import com.zy.gisim.domain.ReqActiveEntity;
import com.zy.gisim.domain.ReqActiveMemberEntity;
import com.zy.gisim.model.ActiveEntity;
import com.zy.gisim.model.ActiveTypeEntity;
import com.zy.gisim.model.ResponseEntity;

import java.util.List;

public interface ActiveService {
    /**
     * 获取所有活动分类
     * @return
     */
    ResponseEntity<List<ActiveTypeEntity>> findAllActiveType();

    /**
     * 创建活动
     * @param entity
     * @return
     */
    ResponseEntity<Boolean> createActive(ReqActiveEntity entity);

    /**
     * 修改活动
     * @param entity
     * @return
     */
    ResponseEntity<Boolean> modifyActive(ReqActiveEntity entity);

    /**
     * 删除活动
     * @param id
     * @return
     */
    ResponseEntity<Boolean> removeActive(int id);

    /**
     * 获取用户参见的活动
     * @param userid
     * @return
     */
    ResponseEntity<List<ActiveEntity>> findActiveByUser(int userid);

    /**
     * 添加成员
     * @param entity
     * @return
     */
    ResponseEntity<Boolean> addMember(ReqActiveMemberEntity entity);

    /**
     * 删除成员
     * @param activeid
     * @param memberid
     * @return
     */
    ResponseEntity<Boolean> removeMember(int activeid,int memberid);

    /**
     * 修改成员昵称
     * @param activeid
     * @param memberid
     * @param nick
     * @return
     */
    ResponseEntity<Boolean> modifyNick(int activeid,int memberid,String nick);

    /**
     * 同意加入活动
     * @param activeid
     * @param memberid
     * @return
     */
    ResponseEntity<Boolean> agree(int activeid,int memberid);

    /**
     * 拒绝加入活动
     * @param activeid
     * @param memberid
     * @return
     */
    ResponseEntity<Boolean> refuse(int activeid,int memberid);

    /**
     * 退出活动
     * @param activeid
     * @param memberid
     * @return
     */
    ResponseEntity<Boolean> quitActive(int activeid,int memberid);

    /**
     * 是否活动的创建者
     * @param activeid
     * @param memberid
     * @return
     */
    ResponseEntity<Boolean> isOwner(int activeid,int memberid);

    /**
     * 申请加入活动
     * @param entity
     * @return
     */
    ResponseEntity<Boolean> reqJoinActive(ReqActiveMemberEntity entity);

    /**
     * 同意申请加入活动
     * @param activeid
     * @param memberid
     * @return
     */
    ResponseEntity<Boolean> agreeReq(int activeid,int memberid);

    /**
     * 拒绝申请
     * @param activeid
     * @param memberid
     * @return
     */
    ResponseEntity<Boolean> refuseReq(int activeid,int memberid);
}
