package com.zy.gisim.services.impl;

import com.zy.gisim.domain.ReqActiveEntity;
import com.zy.gisim.domain.ReqActiveMemberEntity;
import com.zy.gisim.mapper.ActiveMapper;
import com.zy.gisim.model.ActiveEntity;
import com.zy.gisim.model.ActiveTypeEntity;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.services.ActiveService;
import com.zy.gisim.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ActiveService")
public class ActiveServiceImpl implements ActiveService {
    @Autowired
    ActiveMapper mapper;

    @Override
    public ResponseEntity<List<ActiveTypeEntity>> findAllActiveType() {
        List<ActiveTypeEntity> result = mapper.findAllActiveType();
        if (result==null||result.size()==0){
            return ResponseUtils.failed("没有检索到符合条件的记录");
        }
        return ResponseUtils.success(result);
    }

    @Override
    public ResponseEntity<Boolean> createActive(ReqActiveEntity entity) {
        boolean result = mapper.createActive(entity);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("创建活动失败");
    }

    @Override
    public ResponseEntity<Boolean> modifyActive(ReqActiveEntity entity) {
        boolean result = mapper.modifyActive(entity);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("修改活动失败");
    }

    @Override
    public ResponseEntity<Boolean> removeActive(int id) {
        boolean result = mapper.removeActive(id);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("删除活动失败");
    }

    @Override
    public ResponseEntity<List<ActiveEntity>> findActiveByUser(int userid) {
        List<ActiveEntity> result = mapper.findActiveByUser(userid);
        if (result==null||result.size()==0){
            return ResponseUtils.failed("没有检索到符合条件的数据记录");
        }
        return ResponseUtils.success(result);
    }

    @Override
    public ResponseEntity<Boolean> addMember(ReqActiveMemberEntity entity) {
        boolean result = mapper.addMember(entity);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("添加成员失败");
    }

    @Override
    public ResponseEntity<Boolean> removeMember(int activeid, int memberid) {
        boolean result = mapper.removeMember(activeid,memberid);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("删除成员失败");
    }

    @Override
    public ResponseEntity<Boolean> modifyNick(int activeid, int memberid, String nick) {
        boolean result = mapper.modifyNick(activeid,memberid,nick);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("修改成员失败");
    }

    @Override
    public ResponseEntity<Boolean> agree(int activeid, int memberid) {
        boolean result = mapper.agree(activeid,memberid);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("同意加入活动失败");
    }

    @Override
    public ResponseEntity<Boolean> refuse(int activeid, int memberid) {
        boolean result = mapper.refuse(activeid,memberid);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("拒绝加入活动失败");
    }

    @Override
    public ResponseEntity<Boolean> quitActive(int activeid, int memberid) {
        boolean result = mapper.quitActive(activeid,memberid);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("退出活动失败");
    }

    @Override
    public ResponseEntity<Boolean> isOwner(int activeid, int memberid) {
        boolean result = mapper.isOwner(activeid,memberid);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("操作失败");
    }
}
