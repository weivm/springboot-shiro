package com.example.demoshiro.entity;

/**
 * @author Weigor
 * @date ${date} ${time}
 */
public class Role {
    private int roleid;//角色编号
    private String role;//角色职位

    public Role() {
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", role='" + role + '\'' +
                '}';
    }
}
