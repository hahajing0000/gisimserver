package com.zy.gisim.services;

import com.zy.gisim.domain.ReqMsgEntity;
import com.zy.gisim.model.MsgEntity;
import com.zy.gisim.model.MsgTypeEntity;
import com.zy.gisim.model.ResponseEntity;

import java.util.List;

public interface MsgService {
    /**
     * 获取所有消息分类
     * @return
     */
    ResponseEntity<List<MsgTypeEntity>> findAllMsgTypes();

    /**
     * 发送消息
     * @param entity
     * @return
     */
    ResponseEntity<Boolean> sendMsg(ReqMsgEntity entity);

    /**
     * 接收消息
     * @param entity
     * @return
     */
    ResponseEntity<Boolean> receiveMsg(ReqMsgEntity entity);

    /**
     * 删除指定消息
     * @param id
     * @return
     */
    ResponseEntity<Boolean> removeMsg(int id);

    /**
     * 标记消息已读
     * @param ids
     * @return
     */
    ResponseEntity<Boolean> readMsg(List<Integer> ids);

    /**
     * 获取与指定用户的聊天记录
     * @param userid 当前用户
     * @param friendid 指定用户
     * @return
     */
    ResponseEntity<List<MsgEntity>> findMsgsByUser(int userid, int friendid,int page,int pagesize);
}
