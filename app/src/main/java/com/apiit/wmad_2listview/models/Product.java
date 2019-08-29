package com.apiit.wmad_2listview.models;

public class Product {

    private String name;
    private Double price;
    private int quantity;
    private String description;
    private int rating;

    public Product() {
    }

    public Product(String name, Double price, int quantity, String description, int rating) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}