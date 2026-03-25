package com.ecommerce.service;

import com.ecommerce.config.DBConnection;
import com.ecommerce.model.Product;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminProductService {
    Connection con = DBConnection.getConnection();

    public void addProducts(Product p) {
        try {

            String sql = "INSERT INTO products(category,name,price,quantity) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getCategory());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getQuantity());
            ps.executeUpdate();
            System.out.print("Product added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product p) {
        try {

            String sql = "UPDATE products SET category=? ,name=?,price=?,quantity=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getCategory());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getQuantity());
            ps.executeUpdate();
            System.out.print("Product added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        try {

            String sql = "DELETE FROM products WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Product removed Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewProducts() {
        try {
            String sql = "SELECT * FROM products";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID:" + rs.getInt("id") +
                        " Name:" + rs.getString("name") +
                        " Price:" + rs.getDouble("price") +
                        " Quantity:" + rs.getInt("quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

