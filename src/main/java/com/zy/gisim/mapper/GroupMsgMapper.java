package com.zy.gisim.mapper;

import com.zy.gisim.domain.ReqGroupMsgEntity;
import com.zy.gisim.domain.ReqIdEntity;
import com.zy.gisim.domain.ReqMsgEntity;
import com.zy.gisim.model.GroupMsgEntity;
import com.zy.gisim.model.MsgEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMsgMapper {
    /**
     * 发送消息
     * @param entity
     * @return
     */
    boolean sendMsg(ReqGroupMsgEntity entity);

    /**
     * 接收消息
     * @param entity
     * @return
     */
    boolean receiveMsg(ReqGroupMsgEntity entity);

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
    boolean readMsg(List<ReqIdEntity> ids);

    /**
     * 获取与指定用户的聊天记录
     * @param userid 当前用户
     * @param groupid 群组id
     * @return
     */
    List<GroupMsgEntity> findGroupMsgByUser(int userid, int groupid, int page, int pagesize);
}
