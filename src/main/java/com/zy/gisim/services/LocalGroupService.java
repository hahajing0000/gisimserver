package com.zy.gisim.services;

import com.zy.gisim.domain.ReqLocalGroupEntity;
import com.zy.gisim.model.LocalGroupEntity;
import com.zy.gisim.model.ResponseEntity;

import java.util.List;

public interface LocalGroupService {
    /**
     * 创建本地分组
     * @param entity
     * @return
     */
    ResponseEntity<Boolean> createLocalGroup(ReqLocalGroupEntity entity);

    /**
     * 删除本地分组
     * @param groupid
     * @return
     */
    ResponseEntity<Boolean> deleteLocalGroup(int groupid);

    /**
     * 修改本地分组
     * @param entity
     * @return
     */
    ResponseEntity<Boolean> modifyLocalGroup(ReqLocalGroupEntity entity);

    /**
     * 获取指定用户的本地分组
     * @param userid
     * @return
     */
    ResponseEntity<List<LocalGroupEntity>> findByUserId(int userid);

    /**
     * 根据id获取分组信息
     * @param groupid
     * @return
     */
    ResponseEntity<LocalGroupEntity> findById(int groupid);


    /**
     * 修改成员数量
     * @param groupid 分组id
     * @param relativeCount 相对数
     * @return
     */
    ResponseEntity<Boolean> modifyMemberCount(int groupid,int relativeCount);
}
