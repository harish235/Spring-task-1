package com.quinbay.springtask.controllers;


import com.quinbay.springtask.interfaces.ProductInterface;
import com.quinbay.springtask.models.Product;
import com.quinbay.springtask.models.Retailer;
import com.quinbay.springtask.models.Wholesaler;
import com.quinbay.springtask.services.productservice;
import com.quinbay.springtask.services.retailerservice;
import com.quinbay.springtask.services.wholesalerservice;
import com.quinbay.springtask.services.retailerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import com.quinbay.springtask.csvRead;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.WeakHashMap;

@RequestMapping("/products")
@RestController
public class productcontroller {

    List<Product> productList = new ArrayList<>();
    List<Wholesaler> wholesalerList = new ArrayList<>();
    List<Retailer> retailerList = new ArrayList<>();

    csvRead cnew = new csvRead();

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() throws Exception {
        cnew.csvProductData(productList);
        System.out.print("<--------------Product read from CSV-------------->");
        System.out.println(productList.size());
        csvRead.csvWholesalerData(wholesalerList);
        System.out.print("\n<--------------Wholesaler read from CSV-------------->");
        System.out.println(wholesalerList.size());
        csvRead.csvRetailerData(retailerList);
        System.out.print("\n<--------------Retailer fetched from CSV-------------->");
        System.out.println(retailerList.size());
    }
    @Autowired
    productservice pService;

    @Autowired
    wholesalerservice wservice;

    @Autowired
    retailerservice rservice;

    @PostMapping("/addProducts")
    public Product addProducts(@RequestBody Product p){
        Product newP = pService.addProductDetails(p, productList);
//        System.out.println("\nhere "+newP.getName());
        return newP;
    }

    @GetMapping("/getProducts")
    public Product getProducts(@RequestParam int id){
        Product newP = pService.getProductDetails(id, productList);
        System.out.println("getting "+newP.getName());
        return newP;
    }

    @PutMapping("/updateProducts")
    public Product updateProducts(@RequestParam int id, @RequestParam int stock){
        Product newP = pService.updateProduct(id, stock, productList);
        return newP;
    }

    @PostMapping("/addWholesaler")
    public Wholesaler addNewWholesaler(@RequestBody Wholesaler w){
        Wholesaler wnew = wservice.addWholesaler(w, wholesalerList);
        return wnew;
    }

    @GetMapping("/getWholesaler")
    public Wholesaler getWholesalerDetails(@RequestParam int id){
        Wholesaler wnew = wservice.getWholesaler(id, wholesalerList);
        return wnew;
    }

    @PutMapping("/updateWholesaler")
    public Wholesaler updateWholesaler(@RequestParam int w_id, @RequestParam int p_d, @RequestParam int stock ){
        Wholesaler wnew = wservice.updateWholesalerStock(w_id, p_d, stock, wholesalerList, productList);
        return wnew;
    }

    @PostMapping("/addRetailer")
    public Retailer addRetailer(@RequestBody Retailer r){
        Retailer rnew = rservice.addRetailer(r, retailerList);
        return rnew;
    }

    @GetMapping("/getRetailer")
    public Retailer getRetailer(@RequestParam int id){
        Retailer rnew = rservice.getRetailer(id, retailerList);
        return rnew;
    }

    @PutMapping("/updateRetailer")
    public Retailer updateRetailer(@RequestParam int r_id, @RequestParam int w_id, @RequestParam int p_id, @RequestParam int stock ){
        Retailer rnew = rservice.updateRetailer(r_id, w_id, p_id, stock, retailerList);
        return rnew;
    }

}
