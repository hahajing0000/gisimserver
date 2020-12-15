package com.zy.gisim.services;

import com.zy.gisim.domain.ReqGroupEntity;
import com.zy.gisim.domain.ReqGroupMemberEntity;
import com.zy.gisim.model.GroupEntity;
import com.zy.gisim.model.GroupMemberEntity;
import com.zy.gisim.model.GroupTypeEntity;
import com.zy.gisim.model.ResponseEntity;

import java.util.List;

public interface GroupService {
    /**
     * 获取所有群组类型
     * @return
     */
    ResponseEntity<List<GroupTypeEntity>> findAllTypes();

    /**
     * 创建分组
     * @param entity
     * @return
     */
    ResponseEntity<Boolean> createGroup(ReqGroupEntity entity);

    /**
     * 修改分组
     * @param entity
     * @return
     */
    ResponseEntity<Boolean> modifyGroup(ReqGroupEntity entity);

    /**
     * 删除分组
     * @param id
     * @return
     */
    ResponseEntity<Boolean> deleteGroup(int id);

    /**
     * 获取指定用户创建的所有分组
     * @param userid
     * @return
     */
    ResponseEntity<List<GroupEntity>> findByOwnerId(int userid);

    /**
     * 获取用户加入的分组
     * @param usreid
     * @return
     */
    ResponseEntity<List<GroupEntity>> findByUserJoinGroups(int usreid);

    /**
     * 根据关键字查询在组编码及组名称包含关键字的群组信息
     * @param keyword
     * @return
     */
    ResponseEntity<List<GroupEntity>> queryByKeyword(String keyword);

    /**
     * 加入群组
     * @param entity
     * @return
     */
    ResponseEntity<Boolean> joinGroup(ReqGroupMemberEntity entity);

    /**
     * 删除成员
     * @param id
     * @return
     */
    ResponseEntity<Boolean> removeMember(int id);

    /**
     * 修改昵称
     * @param id
     * @param nick
     * @return
     */
    ResponseEntity<Boolean> modifyNick(int id,String nick);

    /**
     * 申请成为管理员
     * @param id
     * @return
     */
    ResponseEntity<Boolean> requestAdmin(int id);

    /**
     * 撤销管理
     * @param id
     * @return
     */
    ResponseEntity<Boolean> repealAdmin(int id);

    /**
     * 修改成员进群状态 状态 0-邀请进群 1-申请进群 2-同意进群|已进群 3-拒绝进群
     * @param id
     * @param status
     * @return
     */
    ResponseEntity<Boolean> modifyStatus(int id,int status);

    /**
     * 获取指定分组下的成员列表
     * @param groupid
     * @return
     */
    ResponseEntity<List<GroupMemberEntity>> findByGroupId(int groupid);

    /**
     * 退群
     * @param groupid
     * @param userid
     * @return
     */
    ResponseEntity<Boolean> quitGroup(int groupid,int userid);
}
