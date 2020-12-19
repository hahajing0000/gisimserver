package com.zy.gisim.mapper;

import com.zy.gisim.domain.ReqActiveEntity;
import com.zy.gisim.domain.ReqActiveMemberEntity;
import com.zy.gisim.model.ActiveEntity;
import com.zy.gisim.model.ActiveTypeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiveMapper {
    /**
     * 获取所有活动分类
     * @return
     */
    List<ActiveTypeEntity> findAllActiveType();

    /**
     * 创建活动
     * @param entity
     * @return
     */
    boolean createActive(ReqActiveEntity entity);

    /**
     * 修改活动
     * @param entity
     * @return
     */
    boolean modifyActive(ReqActiveEntity entity);

    /**
     * 删除活动
     * @param id
     * @return
     */
    boolean removeActive(int id);

    /**
     * 获取用户参见的活动
     * @param userid
     * @return
     */
    List<ActiveEntity> findActiveByUser(int userid);

    /**
     * 添加成员
     * @param entity
     * @return
     */
    boolean addMember(ReqActiveMemberEntity entity);

    /**
     * 申请加入活动
     * @param entity
     * @return
     */
    boolean reqJoinActive(ReqActiveMemberEntity entity);

    /**
     * 删除成员
     * @param activeid
     * @param memberid
     * @return
     */
    boolean removeMember(int activeid,int memberid);

    /**
     * 修改成员昵称
     * @param activeid
     * @param memberid
     * @param nick
     * @return
     */
    boolean modifyNick(int activeid,int memberid,String nick);

    /**
     * 同意加入活动
     * @param activeid
     * @param memberid
     * @return
     */
    boolean agree(int activeid,int memberid);

    /**
     * 同意申请加入活动
     * @param activeid
     * @param memberid
     * @return
     */
    boolean agreeReq(int activeid,int memberid);

    /**
     * 拒绝加入活动
     * @param activeid
     * @param memberid
     * @return
     */
    boolean refuse(int activeid,int memberid);

    /**
     * 拒绝申请
     * @param activeid
     * @param memberid
     * @return
     */
    boolean refuseReq(int activeid,int memberid);

    /**
     * 退出活动
     * @param activeid
     * @param memberid
     * @return
     */
    boolean quitActive(int activeid,int memberid);

    /**
     * 是否活动的创建者
     * @param activeid
     * @param memberid
     * @return
     */
    int isOwner(int activeid,int memberid);
}
