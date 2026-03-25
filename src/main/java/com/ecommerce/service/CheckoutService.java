package com.ecommerce.service;

import com.ecommerce.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckoutService implements CheckoutInterface {
    @Override
    public void checkout(int userId) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT p.name, p.price, c.quantity FROM cartitem c JOIN products p ON c.product_id = p.id WHERE c.user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            double total = 0;

            while (rs.next()) {

                String productName = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");

                double itemTotal = price * quantity;
                total += itemTotal;

                // insert each item into orders table
                String orderSql = "INSERT INTO orders(user_id,product_name,quantity,total) VALUES(?,?,?,?)";
                PreparedStatement orderPs = con.prepareStatement(orderSql);

                orderPs.setInt(1, userId);
                orderPs.setString(2, productName);
                orderPs.setInt(3, quantity);
                orderPs.setDouble(4, itemTotal);

                orderPs.executeUpdate();
            }

            System.out.println("Total Amount: " + total);

            // clear cart
            String deleteSql = "DELETE FROM cartitem WHERE user_id=?";
            PreparedStatement deletePs = con.prepareStatement(deleteSql);
            deletePs.setInt(1, userId);
            deletePs.executeUpdate();

            System.out.println("Order placed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}