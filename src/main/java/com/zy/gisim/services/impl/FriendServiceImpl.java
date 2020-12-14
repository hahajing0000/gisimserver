package com.zy.gisim.services.impl;

import com.zy.gisim.domain.ReqFriendEntity;
import com.zy.gisim.mapper.FriendMapper;
import com.zy.gisim.model.FriendEntity;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.services.FriendService;
import com.zy.gisim.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FriendServiceImpl")
public class FriendServiceImpl implements FriendService {
    @Autowired
    FriendMapper mapper;

    @Override
    public ResponseEntity<Boolean> addFriend(ReqFriendEntity entity) {
        boolean result = mapper.addFriend(entity);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("添加好友失败");
    }

    @Override
    public ResponseEntity<Boolean> deleteFriend(int userid, int friendid) {
        boolean result = mapper.deleteFriend(userid, friendid);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("删除好友失败");
    }

    @Override
    public ResponseEntity<Boolean> modifyAlias(int userid, int friendid, String alias) {
        boolean result = mapper.modifyAlias(userid, friendid, alias);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("修改好友备注名称失败");
    }

    @Override
    public ResponseEntity<Boolean> changeLocalGroup(int userid, int friendid, int groupid) {
        boolean result = mapper.changeLocalGroup(userid, friendid, groupid);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("修改好友本地分组失败");
    }

    @Override
    public ResponseEntity<List<FriendEntity>> findByUserid(int userid) {
        List<FriendEntity> result = mapper.findByUserid(userid);
        if (result==null||result.size()==0){
            return ResponseUtils.failed("没有检索到符合条件的数据记录");
        }
        return ResponseUtils.success(result);
    }

    @Override
    public ResponseEntity<List<FriendEntity>> findByUseridGroupid(int userid, int groupid) {
        List<FriendEntity> result = mapper.findByUseridGroupid(userid,groupid);
        if (result==null||result.size()==0){
            return ResponseUtils.failed("没有检索到符合条件的数据记录");
        }
        return ResponseUtils.success(result);
    }

    @Override
    public ResponseEntity<FriendEntity> findById(int userid, int friendid) {
        FriendEntity result = mapper.findById(userid, friendid);
        if (result==null){
            return ResponseUtils.failed("没有检索到符合条件的数据记录");
        }
        return ResponseUtils.success(result);
    }
}
