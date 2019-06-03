package com.example.demoshiro.dao;

import com.example.demoshiro.entity.UserRole;
import org.apache.ibatis.annotations.Select;

/**
 * @author Weigor
 * @date ${date} ${time}
 */
public interface UserRoleMapper {

    @Select("select * from user_role where userid=#{userid}")
    UserRole findrole(int userid);

}
