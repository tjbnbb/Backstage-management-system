package com.tjb.backend.bean;

public class UsersBean {
    private String username;//主键
    private String pass;

    public UsersBean(String username,String pass) {
        this.username=username;
        this.pass=pass;
    }

    public String getusername() {
        return username;
    }

    public String getpass() { return pass; }

    public void setusername(String username) {
        this.username = username;
    }

    public void setpass(String pass) {
        this.pass = pass;
    }
}
