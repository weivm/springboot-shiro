package com.example.demoshiro.ShiroConfig;


import com.example.demoshiro.entity.Permission;
import com.example.demoshiro.entity.User;
import com.example.demoshiro.entity.UserRole;
import com.example.demoshiro.service.Permissionservice;
import com.example.demoshiro.service.UserRoleservice;
import com.example.demoshiro.service.Userservice;
import com.example.demoshiro.until.Md5;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Weigor
 * @date ${date} ${time}
 */

public class Shirorealm extends AuthorizingRealm {
@Autowired
private Userservice userservice;

@Autowired
private UserRoleservice roleservice;

@Autowired

private Permissionservice permissionservice;
    /**
     * 授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("--开始进入授权逻辑");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        User user= (User) principalCollection.getPrimaryPrincipal();
       /* Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();*/
        Set<String> permission = new HashSet<String>();
            UserRole role=roleservice.getfindrole(user.getUserid());
            System.out.println("--角色为--:"+role.getRoleid());
            List<Permission>list=permissionservice.getfind(role.getRoleid());
            for (Permission p:list){
                System.out.println("--权限为--:"+p.getUrl());

                permission.add(p.getUrl());
            }

        info.setStringPermissions(permission);

        return  info;


    }


    /**
     * 认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
             System.out.println("---开始进入认证验证---");
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        System.out.println(token.getPassword());
        User user=userservice.getusername(token.getUsername());//通过token令牌中的数据与数据库匹配

        if (user==null){
            return null;
       }
        System.out.println("-------------验证成功--------------");
        //验证
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getSimpleName());
    }
}
