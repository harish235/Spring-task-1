package com.quinbay.springtask.services;

import com.quinbay.springtask.interfaces.ProductInterface;
import com.quinbay.springtask.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class productservice implements ProductInterface {
//    List<Product> productList = new ArrayList<>();
    @Override
    public Product addProductDetails(Product p, List<Product>pList){
        System.out.println(p.getName());
        System.out.println(p.getId());
        pList.add(p);
        System.out.println("\nadded"+pList);
     return p;
    }

    @Override
    public Product getProductDetails(int id, List<Product> pList){
        Product temp = new Product();
        for(Product p: pList){
//            System.out.println("\n product id: "+ p.getId());
            if(p.getId() == id){
//                System.out.println("\nID matched");
                return p;
            }
        }
        return temp;
    }

    @Override
    public Product updateProduct(int id, int stock, List<Product> pList){
        Product temp = new Product();
        for(Product p: pList){
            if(p.getId() == id){
                p.setStock(p.getStock()+ stock);
                return p;
            }
        }
        return temp;
    }

//    public Product updateProductForWholesaler(int id, int stock, List<Product> pList){
//        Product temp = new Product();
//
//        String name="";
//        int price=0;
//        System.out.println("Product list size:  " + productList.size());
//        for(Product p: productList){
//            if(p.getId() == id){
//                System.out.println("\n\t Product ID matched");
//                name = p.getName();
//                price = p.getPrice();
//                Product pNew = new Product(id, name, stock, price);
//                return pNew;
//            }
//        }
//        return temp;
//    }

//    public List<Product> getProductList(){
//        return productList;
//    }
}
