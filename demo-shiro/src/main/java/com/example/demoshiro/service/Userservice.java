package com.example.demoshiro.service;


import com.example.demoshiro.entity.User;

/**
 * @author Weigor
 * @date ${date} ${time}
 */
public interface Userservice {

    User getusername(String username);

    int insertaccount(String password, String username);
}
