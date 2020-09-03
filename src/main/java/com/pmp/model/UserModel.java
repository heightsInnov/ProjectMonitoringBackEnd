package com.pmp.model;

public class UserModel {

    private boolean isLogin;
    private String username;
    private String[] roles;

    public UserModel(String username, boolean isLogin){
        this.username = username;
        this.isLogin = isLogin;
    }
    public String getUsername() {
        return username;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
