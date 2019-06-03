package com.example.demoshiro.entity;

/**
 * @author Weigor
 * @date ${date} ${time}
 */
public class User {
    private int userid;//用户ID
    private String password;//用户密码
    private String username;//用户昵称

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    Boolean lock=Boolean.FALSE;

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }

    public User(String password, String username) {

        this.password = password;
        this.username = username;

    }
    public User() {
    }



    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userid +
                ", password='" + password + '\'' +
                '}';
    }
}
