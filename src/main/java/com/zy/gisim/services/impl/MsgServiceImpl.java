package com.zy.gisim.services.impl;

import com.zy.gisim.domain.ReqMsgEntity;
import com.zy.gisim.mapper.MsgMapper;
import com.zy.gisim.model.MsgEntity;
import com.zy.gisim.model.MsgTypeEntity;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.services.MsgService;
import com.zy.gisim.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MsgService")
public class MsgServiceImpl implements MsgService {

    @Autowired
    MsgMapper mapper;

    @Override
    public ResponseEntity<List<MsgTypeEntity>> findAllMsgTypes() {
        List<MsgTypeEntity> result = mapper.findAllMsgTypes();
        if (result==null||result.size()==0){
            return ResponseUtils.failed("没有检索到符合条件的数据记录");
        }
        return ResponseUtils.success(result);
    }

    @Override
    public ResponseEntity<Boolean> sendMsg(ReqMsgEntity entity) {
        boolean result = mapper.sendMsg(entity);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("发送消息失败");
    }

    @Override
    public ResponseEntity<Boolean> receiveMsg(ReqMsgEntity entity) {
        boolean result = mapper.receiveMsg(entity);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("接收消息失败");
    }

    @Override
    public ResponseEntity<Boolean> removeMsg(int id) {
        boolean result = mapper.removeMsg(id);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("删除消息失败");
    }

    @Override
    public ResponseEntity<Boolean> readMsg(List<Integer> ids) {
        boolean result = mapper.readMsg(ids);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("消息更改已读状态失败");
    }

    @Override
    public ResponseEntity<List<MsgEntity>> findMsgsByUser(int userid, int friendid,int page,int pagesize) {
        List<MsgEntity> result = mapper.findMsgsByUser(userid, friendid,page,pagesize);
        if (result==null||result.size()==0){
            return ResponseUtils.failed("没有检索到符合条件的数据记录");
        }
        return ResponseUtils.success(result);
    }
}
