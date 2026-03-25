package com.ecommerce.model;

public class Admin {
    String adminname;
    String password;
    public Admin(String name,String password){
        this.adminname=name;
        this.password=password;
    }
    public String getUsername(){

        return adminname;
    }
    public String getPassword(){

        return password;
    }
}
