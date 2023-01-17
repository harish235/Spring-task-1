package com.quinbay.springtask.interfaces;

import com.quinbay.springtask.models.Retailer;

import java.util.List;

public interface RetailerInterface {

    Retailer addRetailer(Retailer r, List<Retailer> rList);
    Retailer getRetailer(int id, List<Retailer> rList);
    Retailer updateRetailer(int r_id, int w_id, int p_id, int stock, List<Retailer> rList);
}
