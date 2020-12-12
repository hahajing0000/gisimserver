package com.zy.gisim.mapper;

import com.zy.gisim.domain.ReqLocalGroupEntity;
import com.zy.gisim.model.LocalGroupEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalGroupMapper {
    /**
     * 创建本地分组
     * @param entity
     * @return
     */
    boolean createLocalGroup(ReqLocalGroupEntity entity);

    /**
     * 删除本地分组
     * @param groupid
     * @return
     */
    boolean deleteLocalGroup(int groupid);

    /**
     * 修改本地分组
     * @param entity
     * @return
     */
    boolean modifyLocalGroup(ReqLocalGroupEntity entity);

    /**
     * 获取指定用户的本地分组
     * @param userid
     * @return
     */
    List<LocalGroupEntity> findByUserId(int userid);

    /**
     * 根据id获取分组信息
     * @param groupid
     * @return
     */
    LocalGroupEntity findById(int groupid);


    /**
     * 修改成员数量
     * @param groupid 分组id
     * @param relativeCount 相对数
     * @return
     */
    boolean modifyMemberCount(int groupid,int relativeCount);
}
