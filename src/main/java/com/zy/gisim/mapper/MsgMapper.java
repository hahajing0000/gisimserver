package com.zy.gisim.mapper;

import com.zy.gisim.domain.ReqMsgEntity;
import com.zy.gisim.model.MsgEntity;
import com.zy.gisim.model.MsgTypeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MsgMapper {
    /**
     * 获取所有消息分类
     * @return
     */
    List<MsgTypeEntity> findAllMsgTypes();

    /**
     * 发送消息
     * @param entity
     * @return
     */
    boolean sendMsg(ReqMsgEntity entity);

    /**
     * 接收消息
     * @param entity
     * @return
     */
    boolean receiveMsg(ReqMsgEntity entity);

    /**
     * 删除指定消息
     * @param id
     * @return
     */
    boolean removeMsg(int id);

    /**
     * 标记消息已读
     * @param ids
     * @return
     */
    boolean readMsg(List<Integer> ids);

    /**
     * 获取与指定用户的聊天记录
     * @param userid 当前用户
     * @param friendid 指定用户
     * @return
     */
    List<MsgEntity> findMsgsByUser(int userid,int friendid,int page,int pagesize);
}
