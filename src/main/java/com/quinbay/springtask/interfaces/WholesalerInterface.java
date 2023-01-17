package com.quinbay.springtask.interfaces;

import com.quinbay.springtask.models.Product;
import com.quinbay.springtask.models.Wholesaler;

import java.util.List;

public interface WholesalerInterface {
    Wholesaler addWholesaler(Wholesaler w, List<Wholesaler> wList);
    Wholesaler getWholesaler(int id, List<Wholesaler> wList);
    Wholesaler updateWholesalerStock(int id, int p_id, int stock, List<Wholesaler> wList, List<Product> pList);
}
