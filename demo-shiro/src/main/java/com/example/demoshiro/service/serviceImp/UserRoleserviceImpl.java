package com.example.demoshiro.service.serviceImp;

import com.example.demoshiro.dao.UserRoleMapper;
import com.example.demoshiro.entity.UserRole;
import com.example.demoshiro.service.UserRoleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Weigor
 * @date ${date} ${time}
 */
@Service
public class UserRoleserviceImpl implements UserRoleservice {

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public UserRole getfindrole(int userid) {
        return userRoleMapper.findrole(userid);
    }
}
