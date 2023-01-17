package com.quinbay.springtask;

import com.quinbay.springtask.models.Product;
import com.quinbay.springtask.models.Retailer;
import com.quinbay.springtask.models.Wholesaler;

import java.io.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class csvRead {

    public void csvProductData(List<Product> p) throws Exception{
        Scanner ps = new Scanner(new File("/Users/harish/IdeaProjects/ProductManagement/src/Products.csv"));
        while (ps.hasNext())  //returns a boolean value
        {
            String curr_line = ps.next();
            String[] entities = curr_line.split(",");
            Product pnew = new Product(Integer.parseInt(entities[0]), entities[1], Integer.parseInt(entities[2]), Integer.parseInt(entities[3]));
            p.add(pnew);
        }
        ps.close();
    }

    public static void csvWholesalerData(List<Wholesaler> w) throws Exception{
        Scanner ws = new Scanner(new File("/Users/harish/IdeaProjects/ProductManagement/src/Wholesaler.csv"));
        while (ws.hasNext())  //returns a boolean value
        {
            String curr_line = ws.next();
            String[] entities = curr_line.split(",");
            List<Product> productTemp = new ArrayList<>();
            Wholesaler wnew = new Wholesaler(Integer.parseInt(entities[0]), entities[1], productTemp);
            w.add(wnew);
        }
        ws.close();
    }

    public static void csvRetailerData(List<Retailer> r) throws Exception{
        Scanner rs = new Scanner(new File("/Users/harish/IdeaProjects/ProductManagement/src/Retailer.csv"));
        while (rs.hasNext())  //returns a boolean value
        {
            String curr_line = rs.next();
            String[] entities = curr_line.split(",");
            List<Product> productTemp = new ArrayList<>();
            Retailer rnew = new Retailer(Integer.parseInt(entities[0]), entities[1], productTemp);
            r.add(rnew);
        }
        rs.close();
    }
}
