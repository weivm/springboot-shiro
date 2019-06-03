package com.example.demoshiro.ShiroConfig;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author Weigor
 * @date ${date} ${time}
 */

/**
 * 1创建ShiroFilterFactoryBean
 * 2创建DefaultWebSecurityManager
 * 3创建自定义shiro
 */
@Configuration
public class ShiroConfig  {



    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *  常用的过滤器：
         *      anon: 无需认证（登录）可以访问
         *      authc: 必须认证才可以访问
         *      user: 如果使用rememberMe功能可以直接访问
         *      perms: 该资源必须得到资源权限才可以访问
         *      role: 该资源必须得到角色权限才可以访问
         */

        Map<String, String> filerMap = new LinkedHashMap<>(); //顺序的map
        shiroFilterFactoryBean.setLoginUrl("/tologin");
        //设置未授权的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/err");
       filerMap.put("/index","anon");
        filerMap.put("/login","anon");
        //授权过滤器
        filerMap.put("/add","perms[user:add]");
        filerMap.put("/update","perms[user:update]");
        filerMap.put("/role","perms[role:select]");

        filerMap.put("/*","authc");



        //设置过滤器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filerMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") Shirorealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public Shirorealm getRealm(){
        return new Shirorealm();
    }

    /**
     * 配置ShiroDialect，用于thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }



}
