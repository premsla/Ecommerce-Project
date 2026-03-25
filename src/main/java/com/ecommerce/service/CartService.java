package com.ecommerce.service;

import com.ecommerce.config.DBConnection;
import com.ecommerce.model.CartItem;
import com.ecommerce.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.ecommerce.service.UserService.user_id;

public class CartService{
    public void addItem(CartItem c){
        Connection con= DBConnection.getConnection();
        try {
            String sql = "INSERT INTO cartitem(user_id,product_id,product_name,quantity) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,user_id);
            ps.setInt(2,c.getProduct().getId());
            ps.setString(3,c.getProduct().getName());
            ps.setInt(4,c.getQuantity());
            ps.executeUpdate();
            System.out.print("Product added into cart");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void viewCart(){
        Connection con=DBConnection.getConnection();
        try{
            String sql="SELECT * FROM cartitem";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                System.out.println("ID:" + rs.getInt("id") +
                        " Name:" + rs.getString("product_name") +
                        " Quantity:" + rs.getInt("quantity"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}