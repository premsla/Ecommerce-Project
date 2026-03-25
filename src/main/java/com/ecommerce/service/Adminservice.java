package com.ecommerce.service;
import com.ecommerce.config.DBConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Adminservice {

    public boolean adminLogin(String adminname, String password) {
        try {
            Connection con= DBConnection.getConnection();
            String sql="SELECT * FROM admin WHERE adminname=? AND password=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,adminname);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}