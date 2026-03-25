package com.ecommerce;

import com.ecommerce.Controller.*;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.service.*;


import java.util.Scanner;
import java.io.*;

public class Main {
    private static UserService service;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        AdminController adminController = new AdminController();

        while (true) {
            System.out.println(" Ecommerce Project");
            System.out.println("1. User Signup/Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            UserController userController = new UserController();
            switch (choice) {
                case 1:
                    System.out.println("1.Signup");
                    System.out.println("2.Login");
                    System.out.println("3.Exit");
                    int userChoice = sc.nextInt();
                    sc.nextLine();
                    if (userChoice == 1) {
                        userController.signUp();
                    } else if (userChoice == 2) {
                        userController.login();
                        AdminProductService productService=new AdminProductService();
                        UserProductController userProductController=new UserProductController();
                        CheckoutController checkoutController = new CheckoutController();
                        CartController cartController=new CartController();
                        OrderHistoryService orderHistoryService=new OrderHistoryService();
                        CartService cartService=new CartService();
                        boolean loggedIn = true;

                        while (loggedIn) {
                            System.out.println("1. View Products");
                            System.out.println("2. Add to Cart");
                            System.out.println("3. View Cart");
                            System.out.println("4. Checkout");
                            System.out.println("5. Order History");
                            System.out.println("6. Logout");

                            int op = sc.nextInt();
                            sc.nextLine();


                            switch (op) {
                                case 1:
                                    productService.viewProducts();

                                    boolean productMenu = true;

                                    while(productMenu){
                                        System.out.println("\nProduct Options");
                                        System.out.println("1. Search Product");
                                        System.out.println("2. Filter by Price");
                                        System.out.println("3. View by Category");
                                        System.out.println("4. Back");

                                        int productOp = sc.nextInt();
                                        sc.nextLine();

                                        switch(productOp){
                                            case 1:
                                                userProductController.searchProduct();
                                                break;

                                            case 2:
                                                userProductController.sortByPrice();
                                                break;

                                            case 3:
                                                userProductController.viewByCategory();
                                                break;

                                            case 4:
                                                productMenu = false;
                                                break;

                                            default:
                                                System.out.println("Invalid option");
                                        }
                                    }

                                    break;
                                case 2:
                                    cartController.addItem();
                                    break;
                                case 3:
                                    cartService.viewCart();
                                    break;
                                case 4:
                                    checkoutController.checkout();
                                    break;
                                case 5:
                                    orderHistoryService.viewOrderHistory();
                                    break;
                                case 6:
                                    loggedIn=false;
                                    break;


                            }

                        }

                    }
                    break;
                case 2:
                    System.out.println("1. Admin Login:");
                    System.out.println("2. Back");
                    int adminChoice = sc.nextInt();
                    sc.nextLine();
                    if (adminChoice == 1) {
                        adminController.adminLogin();
                        boolean adminlogged = true;
                        while (adminlogged) {
                            System.out.println("\n1. Add Product");
                            System.out.println("2. Update Product");
                            System.out.println("3. Delete Product");
                            System.out.println("4. View all available Product");
                            System.out.println("5. Logout");

                            int adminOp = sc.nextInt();
                            AdminProductController adminProductController = new AdminProductController();
                            AdminProductService adminProductService=new AdminProductService();
                            switch (adminOp) {
                                case 1:
                                    adminProductController.addProduct();
                                    break;
                                case 2:
                                    adminProductController.updateProduct();
                                    break;
                                case 3:
                                    adminProductController.removeProduct();
                                    break;
                                case 4:
                                    adminProductService.viewProducts();
                                    break;
                            }

                        }


                    } else {
                        System.out.println("Invalid Admin Credentials");
                    }

                    break;
                case 3:
                    System.out.println("Thank you");
            }
        }

    }
}

