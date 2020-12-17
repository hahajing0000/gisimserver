package com.zy.gisim.services;

import com.zy.gisim.domain.ReqGroupMsgEntity;
import com.zy.gisim.domain.ReqIdEntity;
import com.zy.gisim.model.GroupMsgEntity;
import com.zy.gisim.model.ResponseEntity;

import java.util.List;

public interface GroupMsgService {
    /**
     * 发送消息
     * @param entity
     * @return
     */
    ResponseEntity<Boolean> sendMsg(ReqGroupMsgEntity entity);

    /**
     * 接收消息
     * @param entity
     * @return
     */
    ResponseEntity<Boolean> receiveMsg(ReqGroupMsgEntity entity);

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
    ResponseEntity<Boolean> readMsg(List<ReqIdEntity> ids);

    /**
     * 获取与指定用户的聊天记录
     * @param userid 当前用户
     * @param groupid 群组id
     * @return
     */
    ResponseEntity<List<GroupMsgEntity>> findGroupMsgByUser(int userid, int groupid, int page, int pagesize);
}
