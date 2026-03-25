package com.ecommerce.Controller;
import com.ecommerce.model.User;
import com.ecommerce.service.Adminservice;
import com.ecommerce.service.UserService;

import java.io.*;
import java.util.Scanner;

public class UserController {
    Scanner sc = new Scanner(System.in);
    UserService userService = new UserService();

    public void signUp() {

        System.out.println("Enter Username:");
        String username = sc.nextLine();
        System.out.println("Enter Email:");
        String email=sc.nextLine();
        System.out.println("Enter Password:");
        String password = sc.nextLine();

        User user = new User(username,email,password);
        userService.signUp(user);
    }

    public boolean login() {

        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        boolean result = userService.login(username, password);
        if (result) {
            System.out.println("Login successfull");
            return true;
        } else {
            System.out.print("Incorrect username or password");
            return false;
        }
    }
}

