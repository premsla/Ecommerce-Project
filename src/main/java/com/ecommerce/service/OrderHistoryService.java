package com.ecommerce.service;

import com.ecommerce.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.ecommerce.service.UserService.user_id;

public class OrderHistoryService{
    public void viewOrderHistory(){

        try{

            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM orders WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            System.out.println("Your Order History");

            while(rs.next()){

                System.out.println(
                        "Product: " + rs.getString("product_name") +
                                " Quantity: " + rs.getInt("quantity") +
                                " Total: " + rs.getDouble("total")
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}