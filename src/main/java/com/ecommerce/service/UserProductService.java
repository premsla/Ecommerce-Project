package com.ecommerce.service;
import com.ecommerce.config.DBConnection;
import com.ecommerce.model.Product;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserProductService {
    public void searchProduct(String name) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM products WHERE name LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " "
                                + rs.getString("name") + " "
                                + rs.getDouble("price") + " "
                                + rs.getString("category")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sortByPrice() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM products ORDER BY price ASC";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " "
                                + rs.getString("name") + " "
                                + rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void viewByCategory(String category) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM products WHERE category=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, category);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " "
                                + rs.getString("name") + " "
                                + rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
