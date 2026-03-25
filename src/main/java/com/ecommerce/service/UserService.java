package com.ecommerce.service;

import com.ecommerce.config.DBConnection;
import com.ecommerce.model.User;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

public class UserService {
    public static int user_id;
    boolean login;
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }
    public void signUp(User user) {
        if(!isValidEmail(user.getEmail())){
            System.out.println("Invalid email format");
        }
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO users(username,email,password)VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2,user.getEmail());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();
            System.out.print("User Registered successfully\n");

        } catch (Exception e) {
            System.out.println("Error saving user");
        }
    }

    public boolean login(String username, String password) {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user_id=rs.getInt("id");
                login=true;
            }
            return login;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}