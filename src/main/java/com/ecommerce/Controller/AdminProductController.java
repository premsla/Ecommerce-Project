package com.ecommerce.Controller;

import com.ecommerce.config.DBConnection;
import com.ecommerce.model.Product;
import com.ecommerce.service.AdminProductService;
import com.ecommerce.service.Adminservice;
import java.sql.Connection;
import java.util.Scanner;

public class AdminProductController {
    Scanner sc = new Scanner(System.in);
    AdminProductService adminservice = new AdminProductService();

    public void addProduct() {
        System.out.println("Enter product id:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter product category:");
        String category=sc.nextLine();
        System.out.println("Enter Product Name:");
        String name = sc.nextLine();
        System.out.println("Enter Product Price:");
        Double price = sc.nextDouble();
        System.out.println("Enter Product Quantity");
        int quantity=sc.nextInt();
        Product p = new Product(id,category,name, price,quantity);
        adminservice.addProducts(p);

    }
    public void updateProduct(){
        System.out.println("Enter updated Category");
        String category=sc.nextLine();

        System.out.println("Enter Product name: ");
        String productname=sc.nextLine();
        sc.nextLine();
        System.out.println("Enter Updated Product Price: ");
        int price=sc.nextInt();
        System.out.println("Enter updated quantity: ");
        int quantity=sc.nextInt();
        AdminProductService adminProductService=new AdminProductService();
        Product p=new Product(category,productname,price,quantity);
        adminProductService.updateProduct(p);

    }
    public void removeProduct(){
        System.out.println("Enter Product ID:");
        int id=sc.nextInt();
        adminservice.deleteProduct(id);
    }

}
