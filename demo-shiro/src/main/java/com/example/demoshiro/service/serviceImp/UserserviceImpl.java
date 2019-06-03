package com.example.demoshiro.service.serviceImp;

import com.example.demoshiro.dao.UserMapper;
import com.example.demoshiro.entity.User;
import com.example.demoshiro.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Weigor
 * @date ${date} ${time}
 */
@Service
public class UserserviceImpl implements Userservice {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getusername(String username) {
        return  userMapper.findusername(username);
    }

    @Override
    public int insertaccount(String password, String username) {
        return userMapper.insertaccount(password,username);
    }


}
