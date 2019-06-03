package com.example.demoshiro.entity;

/**
 * @author Weigor
 * @date ${date} ${time}
 */
public class Permission {
    private int id;//唯一
    private String despriction;//权限描述
    private int roleid;//角色
    private String url;//权限字符

    public Permission() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDespriction() {
        return despriction;
    }

    public void setDespriction(String despriction) {
        this.despriction = despriction;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", despriction='" + despriction + '\'' +
                ", roleid=" + roleid +
                ", url='" + url + '\'' +
                '}';
    }
}
