package com.ecommerce.Controller;
import com.ecommerce.model.Admin;
import com.ecommerce.service.Adminservice;

import java.io.*;
import java.util.Scanner;

public class AdminController {
    public void adminLogin(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Admin username: ");
        String adminname=sc.nextLine();
        System.out.println("Admin password: ");
        String password=sc.nextLine();
        Admin admin=new Admin(adminname,password);
        Adminservice adminservice=new Adminservice();
        boolean result=adminservice.adminLogin(admin.getUsername(),admin.getPassword());
        if(result){
            System.out.print("Login successfull");
        }else{
            System.out.print("Invalid credentials");
        }
    }

}
