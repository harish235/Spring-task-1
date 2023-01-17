package com.quinbay.springtask.interfaces;

import com.quinbay.springtask.models.Product;

import java.util.List;

public interface ProductInterface {

    Product addProductDetails(Product p, List<Product> pList);
    Product getProductDetails(int id, List<Product> pList);
    Product updateProduct(int id, int stock, List<Product> pList);
}
