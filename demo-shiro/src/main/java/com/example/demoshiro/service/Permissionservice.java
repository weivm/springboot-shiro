package com.example.demoshiro.service;


import com.example.demoshiro.entity.Permission;

import java.util.List;

/**
 * @author Weigor
 * @date ${date} ${time}
 */
public interface Permissionservice {

    List<Permission> getfind(int roleid);
}
