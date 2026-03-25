package com.ecommerce.model;

public class CartItem {
    private Product product;
    private String productname;
    private int quantity;

    public CartItem(Product product,String productname, int quantity) {
        this.product = product;
        this.productname=productname;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }
}
