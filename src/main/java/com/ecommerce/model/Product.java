package com.ecommerce.model;

public class Product {
    private int id;
    private String category;
    private String name;
    private double price;
    private int quantity;


    public Product( int id,String category,String name, double price,int quantity){
        this.id=id;
        this.category=category;
        this.name = name;
        this.price = price;
        this.quantity=quantity;
    }
    public Product(int id,String name){
        this.id = id;
        this.name=name;
    }
    public Product(String category,String name,int price,int quantity){
        this.category=category;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    public int getId(){
        return id;
    }
    public String getCategory(){

        return category;
    }


    public String getName(){

        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
}
