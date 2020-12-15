package com.zy.gisim.services.impl;

import com.zy.gisim.domain.ReqGroupEntity;
import com.zy.gisim.domain.ReqGroupMemberEntity;
import com.zy.gisim.mapper.GroupMapper;
import com.zy.gisim.model.GroupEntity;
import com.zy.gisim.model.GroupMemberEntity;
import com.zy.gisim.model.GroupTypeEntity;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.services.GroupService;
import com.zy.gisim.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GroupServiceImpl")
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupMapper mapper;

    @Override
    public ResponseEntity<List<GroupTypeEntity>> findAllTypes() {
        List<GroupTypeEntity> result = mapper.findAllTypes();
        if (result==null||result.size()==0){
            return ResponseUtils.failed("没有检索到符合条件的数据记录");
        }
        return ResponseUtils.success(result);
    }

    @Override
    public ResponseEntity<Boolean> createGroup(ReqGroupEntity entity) {
        boolean result = mapper.createGroup(entity);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("创建群组失败");
    }

    @Override
    public ResponseEntity<Boolean> modifyGroup(ReqGroupEntity entity) {
        boolean result = mapper.modifyGroup(entity);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("修改群组失败");
    }

    @Override
    public ResponseEntity<Boolean> deleteGroup(int id) {
        boolean result = mapper.deleteGroup(id);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("删除群组失败");
    }

    @Override
    public ResponseEntity<List<GroupEntity>> findByOwnerId(int userid) {
        List<GroupEntity> result = mapper.findByOwnerId(userid);
        if (result==null||result.size()==0){
            return ResponseUtils.failed("没有检索到符合条件的数据记录");
        }
        return ResponseUtils.success(result);
    }

    @Override
    public ResponseEntity<List<GroupEntity>> findByUserJoinGroups(int usreid) {
        List<GroupEntity> result = mapper.findByUserJoinGroups(usreid);
        if (result==null||result.size()==0){
            return ResponseUtils.failed("没有检索到符合条件的数据记录");
        }
        return ResponseUtils.success(result);
    }

    @Override
    public ResponseEntity<List<GroupEntity>> queryByKeyword(String keyword) {
        List<GroupEntity> result = mapper.queryByKeyword(keyword);
        if (result==null||result.size()==0){
            return ResponseUtils.failed("没有检索到符合条件的数据记录");
        }
        return ResponseUtils.success(result);
    }

    @Override
    public ResponseEntity<Boolean> joinGroup(ReqGroupMemberEntity entity) {
        boolean result = mapper.joinGroup(entity);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("加入群组失败");
    }

    @Override
    public ResponseEntity<Boolean> removeMember(int id) {
        boolean result = mapper.removeMember(id);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("删除群成员失败");
    }

    @Override
    public ResponseEntity<Boolean> modifyNick(int id, String nick) {
        boolean result = mapper.modifyNick(id,nick);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("修改昵称失败");
    }

    @Override
    public ResponseEntity<Boolean> requestAdmin(int id) {
        boolean result = mapper.requestAdmin(id);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("申请管理失败");
    }

    @Override
    public ResponseEntity<Boolean> modifyStatus(int id, int status) {
        boolean result = mapper.modifyStatus(id,status);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("修改成员入组状态失败");
    }

    @Override
    public ResponseEntity<List<GroupMemberEntity>> findByGroupId(int groupid) {
        List<GroupMemberEntity> result = mapper.findByGroupId(groupid);
        if (result==null||result.size()==0){
            return ResponseUtils.failed("没有检索到符合条件的数据记录");
        }
        return ResponseUtils.success(result);
    }

    @Override
    public ResponseEntity<Boolean> quitGroup(int groupid, int userid) {
        boolean result = mapper.quitGroup(groupid,userid);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("退群失败");
    }
}
