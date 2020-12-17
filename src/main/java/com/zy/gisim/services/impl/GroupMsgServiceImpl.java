package com.zy.gisim.services.impl;

import com.zy.gisim.domain.ReqGroupMsgEntity;
import com.zy.gisim.domain.ReqIdEntity;
import com.zy.gisim.mapper.GroupMsgMapper;
import com.zy.gisim.model.GroupMsgEntity;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.services.GroupMsgService;
import com.zy.gisim.utils.ResponseUtils;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("GroupMsgService")
public class GroupMsgServiceImpl implements GroupMsgService {
    @Autowired
    GroupMsgMapper mapper;

    @Override
    public ResponseEntity<Boolean> sendMsg(ReqGroupMsgEntity entity) {
        boolean result = mapper.sendMsg(entity);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("发送群组消息失败");
    }

    @Override
    public ResponseEntity<Boolean> receiveMsg(ReqGroupMsgEntity entity) {
        boolean result = mapper.receiveMsg(entity);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("接收群组消息失败");
    }

    @Override
    public ResponseEntity<Boolean> removeMsg(int id) {
        boolean result = mapper.removeMsg(id);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("删除群组消息失败");
    }

    @Override
    public ResponseEntity<Boolean> readMsg(List<ReqIdEntity> ids) {
        boolean result = mapper.readMsg(ids);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("修改已读状态失败");
    }

    @Override
    public ResponseEntity<List<GroupMsgEntity>> findGroupMsgByUser(int userid, int groupid, int page, int pagesize) {
        List<GroupMsgEntity> result = mapper.findGroupMsgByUser(userid, groupid, page, pagesize);
        if (result==null||result.size()==0){
            return ResponseUtils.failed("没有检索到符合条件的数据记录");
        }
        return ResponseUtils.success(result);
    }
}
