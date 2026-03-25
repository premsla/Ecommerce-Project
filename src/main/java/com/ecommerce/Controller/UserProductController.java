package com.ecommerce.Controller;
import com.ecommerce.config.DBConnection;
import com.ecommerce.service.UserProductService;

import java.io.*;
import java.sql.Connection;
import java.util.Scanner;

public class UserProductController {
    UserProductService service = new UserProductService();
    Scanner sc = new Scanner(System.in);

    public void searchProduct() {
        System.out.println("Enter Product Name:");
        String name = sc.nextLine();
        service.searchProduct(name);
    }

    public void sortByPrice() {
        service.sortByPrice();
    }

    public void viewByCategory() {
        System.out.println("Enter Category:");
        String category = sc.nextLine();
        service.viewByCategory(category);
    }
}
