package com.zy.gisim.mapper;

import com.zy.gisim.domain.ReqGroupEntity;
import com.zy.gisim.domain.ReqGroupMemberEntity;
import com.zy.gisim.model.GroupEntity;
import com.zy.gisim.model.GroupMemberEntity;
import com.zy.gisim.model.GroupTypeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMapper {
    /**
     * 获取所有群组类型
     * @return
     */
    List<GroupTypeEntity> findAllTypes();

    /**
     * 创建分组
     * @param entity
     * @return
     */
    boolean createGroup(ReqGroupEntity entity);

    /**
     * 修改分组
     * @param entity
     * @return
     */
    boolean modifyGroup(ReqGroupEntity entity);

    /**
     * 删除分组
     * @param id
     * @return
     */
    boolean deleteGroup(int id);

    /**
     * 获取指定用户创建的所有分组
     * @param userid
     * @return
     */
    List<GroupEntity> findByOwnerId(int userid);

    /**
     * 获取用户加入的分组
     * @param usreid
     * @return
     */
    List<GroupEntity> findByUserJoinGroups(int usreid);

    /**
     * 根据关键字查询在组编码及组名称包含关键字的群组信息
     * @param keyword
     * @return
     */
    List<GroupEntity> queryByKeyword(String keyword);

    /**
     * 加入群组
     * @param entity
     * @return
     */
    boolean joinGroup(ReqGroupMemberEntity entity);

    /**
     * 删除成员
     * @param id
     * @return
     */
    boolean removeMember(int id);

    /**
     * 修改昵称
     * @param id
     * @param nick
     * @return
     */
    boolean modifyNick(int id,String nick);

    /**
     * 申请成为管理员
     * @param id
     * @return
     */
    boolean requestAdmin(int id);

    /**
     * 修改成员进群状态 状态 0-邀请进群 1-申请进群 2-同意进群|已进群 3-拒绝进群
     * @param id
     * @param status
     * @return
     */
    boolean modifyStatus(int id,int status);

    /**
     * 获取指定分组下的成员列表
     * @param groupid
     * @return
     */
    List<GroupMemberEntity> findByGroupId(int groupid);

    /**
     * 退群
     * @param groupid
     * @param userid
     * @return
     */
    boolean quitGroup(int groupid,int userid);


}
