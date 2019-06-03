package com.example.demoshiro.dao;

import com.example.demoshiro.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Weigor
 * @date ${date} ${time}
 */
public interface UserMapper {

    /**查询用户表的信息根据昵称
     * */
    @Select("select * from user where username=#{username}")
    User findusername(String username);

    /**注册
     * */
    @Insert("insert into user (password,username) values (#{password},#{username})")
    int insertaccount(
            @Param("password") String password,
            @Param("username") String username);


}
