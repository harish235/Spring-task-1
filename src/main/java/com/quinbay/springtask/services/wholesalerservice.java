package com.quinbay.springtask.services;


import com.quinbay.springtask.interfaces.WholesalerInterface;
import com.quinbay.springtask.models.Product;
import com.quinbay.springtask.models.Wholesaler;
import org.springframework.stereotype.Service;
import com.quinbay.springtask.services.productservice;

import javax.websocket.MessageHandler;
import java.util.ArrayList;
import java.util.List;

@Service
public class wholesalerservice implements WholesalerInterface {

//    List<Wholesaler> wholesalerlist = new ArrayList();

    @Override
    public Wholesaler addWholesaler(Wholesaler w, List<Wholesaler> wList){
        wList.add(w);
        return w;
    }

    @Override
    public Wholesaler getWholesaler(int id, List<Wholesaler> wList){
        Wholesaler temp = new Wholesaler();
        for(Wholesaler w: wList){
            if(w.getId() == id){
                return w;
            }
        }
        return temp;
    }


    @Override
    public Wholesaler updateWholesalerStock(int w_id, int p_id, int stock, List<Wholesaler> wList, List<Product> pList){
        Wholesaler temp = new Wholesaler();

        int i;
        for(Wholesaler w: wList){
            if(w.getId() == w_id){
                List<Product> pTemp = w.getProduct();
                for(i=0; i<pTemp.size();i++){
                   if(pTemp.get(i).getId() == p_id){
                       System.out.println("\n\tSetting existing stock");
                       pTemp.get(i).setStock(pTemp.get(i).getStock() + stock);
                       return w;
                   }
                }
                if(i == pTemp.size()){
                    int j;
                    System.out.println("\n\tReached case of new Product");
                    for(j = 0; j< pList.size(); j++){
                        if(pList.get(j).getId() == p_id){
                            Product pnew = new Product(p_id, pList.get(j).getName(), stock, pList.get(j).getPrice());
                            pTemp.add(pnew);
                        }
                    }
                }

//                if(i == pTemp.size()){
//                    System.out.println("\n\tReached case of new product");
//                    productservice pService = new productservice();
////                    Product pNew = pService.updateProductForWholesaler(p_id, stock, pTemp);
////                    pTemp.add(pNew);
//                    List<Product> productTemp = pService.getProductList();
//                    System.out.println("\n\tretrieved list : "+ productTemp.size());
//                    System.out.println(productTemp);
//
//                    return w;
//                }
            }
        }
        return temp;
    }

}
