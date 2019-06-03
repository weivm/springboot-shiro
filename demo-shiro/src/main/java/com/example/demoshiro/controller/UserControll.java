package com.example.demoshiro.controller;


import com.example.demoshiro.entity.User;
import com.example.demoshiro.service.Userservice;
import com.example.demoshiro.until.Md5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author Weigor
 * @date ${date} ${time}
 */
@Controller
public class UserControll {

    @Autowired
    private Userservice userservice;

    /**
     * 跳转登录页面*/

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    /**登录认证跳转
     * */
    @RequestMapping("/login")
    public String login(@RequestParam ("username")String username,
                        @RequestParam("password")String password,
                        HttpSession session
                        ){

            System.out.println("----------进入登录逻辑----");
      /*  IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 创建SecurityManager (根据配置创建SecurityManager实例)
        SecurityManager security = factory.getInstance();
        SecurityUtils.setSecurityManager(security);*/
        String passwordd= Md5.MD5(password);  //md5加密

        //验证用户和密码
        UsernamePasswordToken token=new UsernamePasswordToken(username,passwordd);

        //获取当前主体
        Subject subject = SecurityUtils.getSubject();
       try {

           subject.login(token);//调用subject中的login方法
           User user= (User) subject.getPrincipal();
           session.setAttribute("user",user);
           return "redirect:/index";
       }catch (UnknownAccountException e){
           e.printStackTrace();
           return "/login";
       }



    }



    /**注册
     * */
    @RequestMapping("/register")
    public String register(
                           @RequestParam("password")String password,
                           @RequestParam("username")String username
                           ){
        System.out.println("----开始进入注册------");
            String passwordd= Md5.MD5(password);
        int count=userservice.insertaccount(passwordd,username);
        if (count>0){
            return "login";
        }
        else
            return "register";
    }

   /**增加页面
    * */
    @RequestMapping("/add")
    public String add(){

        return "add";
    }

    /**修改页面
     * */
    @RequestMapping("/update")
    public String update(){

        return "update";
    }

    /**角色页面
     * */
    @RequestMapping("/role")
    public  String role(){

        return "role";
    }

    /**主页
     * */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**认证错误跳转页面
     * */
    @RequestMapping("/err")
    public  String error(){

        return "error";
    }


    /**跳转注册页面
     * */

    @RequestMapping("/toregister")
    public String toregister(){

        return "register";
    }

}
