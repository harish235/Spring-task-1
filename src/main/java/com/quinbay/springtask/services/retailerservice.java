package com.quinbay.springtask.services;


import com.quinbay.springtask.interfaces.RetailerInterface;
import com.quinbay.springtask.models.Product;
import com.quinbay.springtask.models.Retailer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class retailerservice implements RetailerInterface {
    @Override
    public Retailer addRetailer(Retailer r, List<Retailer> rList){
        rList.add(r);
        return r;
    }

    @Override
    public Retailer getRetailer(int id, List<Retailer> rList){
        Retailer temp = new Retailer();
        for(Retailer r: rList){
            if(r.getId() == id){
                return r;
            }
        }
        return temp;
    }

    @Override
    public Retailer updateRetailer(int r_id, int w_id, int p_id, int stock, List<Retailer> rList){
        Retailer temp = new Retailer();

        int i;
//        for(Wholesaler w: wList){
//            if(w.getId() == w_id){
//                List<Product> pTemp = w.getProduct();
//                for(i=0; i<pTemp.size();i++){
//                    if(pTemp.get(i).getId() == p_id){
//                        System.out.println("\n\tSetting existing stock");
//                        pTemp.get(i).setStock(pTemp.get(i).getStock() + stock);
//                        return w;
//                    }
//                }
//                if(i == pTemp.size()){
//                    int j;
//                    System.out.println("\n\tReached case of new Product");
//                    for(j = 0; j< pList.size(); j++){
//                        if(pList.get(j).getId() == p_id){
//                            Product pnew = new Product(p_id, pList.get(j).getName(), stock, pList.get(j).getPrice());
//                            pTemp.add(pnew);
//                        }
//                    }
//                }
//
//            }
//        }
        return temp;
    }
}
