package com.ecommerce.Controller;

import com.ecommerce.config.DBConnection;
import com.ecommerce.model.CartItem;
import com.ecommerce.model.Product;
import com.ecommerce.service.CartService;

import java.sql.Connection;
import java.util.Scanner;

public class CartController {
    Scanner sc=new Scanner(System.in);
    public void addItem(){
        System.out.println("Enter Product id: ");
        int productid = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Product name: ");
        String productname=sc.nextLine();
        System.out.println("Enter Product Quantity: ");
        int q = sc.nextInt();
        Product p = new Product(productid,productname);
        CartItem c = new CartItem(p,productname,q);

        CartService service = new CartService();
        service.addItem(c);
    }
}
