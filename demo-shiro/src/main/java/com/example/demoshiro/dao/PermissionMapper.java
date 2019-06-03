package com.example.demoshiro.dao;

import com.example.demoshiro.entity.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Weigor
 * @date ${date} ${time}
 */
public interface PermissionMapper {
    /**
     * 查询权限表中的角色
     * @param roleid
     * @return
     */
    @Select("select * from permission where roleid=#{roleid}")
    List<Permission>find(int roleid);
}
