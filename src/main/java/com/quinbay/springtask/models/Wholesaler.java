package com.quinbay.springtask.models;

import java.util.List;

public class Wholesaler {
    int id;
    String name;
    List<Product> product;

    public Wholesaler() {
    }

    public Wholesaler(int id, String name, List<Product> product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
