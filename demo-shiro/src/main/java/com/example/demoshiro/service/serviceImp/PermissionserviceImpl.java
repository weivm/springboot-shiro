package com.example.demoshiro.service.serviceImp;


import com.example.demoshiro.dao.PermissionMapper;
import com.example.demoshiro.entity.Permission;
import com.example.demoshiro.service.Permissionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Weigor
 * @date ${date} ${time}
 */
@Service
public class PermissionserviceImpl implements Permissionservice {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> getfind(int roleid) {
        return permissionMapper.find(roleid);
    }
}
