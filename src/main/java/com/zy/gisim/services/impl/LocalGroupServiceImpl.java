package com.zy.gisim.services.impl;

import com.zy.gisim.domain.ReqLocalGroupEntity;
import com.zy.gisim.mapper.LocalGroupMapper;
import com.zy.gisim.model.LocalGroupEntity;
import com.zy.gisim.model.ResponseEntity;
import com.zy.gisim.services.LocalGroupService;
import com.zy.gisim.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LocalGroupServiceImpl")
public class LocalGroupServiceImpl implements LocalGroupService {

    @Autowired
    LocalGroupMapper mapper;

    @Override
    public ResponseEntity<Boolean> createLocalGroup(ReqLocalGroupEntity entity) {
        boolean result = mapper.createLocalGroup(entity);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("创建本地分组失败");
    }

    @Override
    public ResponseEntity<Boolean> deleteLocalGroup(int groupid) {
        boolean result = mapper.deleteLocalGroup(groupid);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("删除本地分组失败");
    }

    @Override
    public ResponseEntity<Boolean> modifyLocalGroup(ReqLocalGroupEntity entity) {
        boolean result = mapper.modifyLocalGroup(entity);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("修改本地分组失败");
    }

    @Override
    public ResponseEntity<List<LocalGroupEntity>> findByUserId(int userid) {
        List<LocalGroupEntity> result = mapper.findByUserId(userid);
        if (result==null||result.size()==0){
            return ResponseUtils.failed("没有检索到符合条件的数据记录");
        }
        return ResponseUtils.success(result);
    }

    @Override
    public ResponseEntity<LocalGroupEntity> findById(int groupid) {
        LocalGroupEntity result = mapper.findById(groupid);
        if (result!=null){
            return ResponseUtils.success(result);
        }
        return ResponseUtils.failed("没有检索到符合条件的数据记录");
    }

    @Override
    public ResponseEntity<Boolean> modifyMemberCount(int groupid, int relativeCount) {
        boolean result = mapper.modifyMemberCount(groupid, relativeCount);
        if (result){
            return ResponseUtils.success(true);
        }
        return ResponseUtils.failed("修改分组成员数量失败");
    }
}
