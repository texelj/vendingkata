package com.texel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jacob on 5/5/2018.
 */
public class ProductStock {
    private Map<Product,Integer> productCounts;

    public ProductStock(int initialStock){
        this.productCounts = new HashMap<Product, Integer>();
        for(Product p: Product.values()){
            this.productCounts.put(p, initialStock);
        }
    }

    public int getProductCount(Product p){
        return this.productCounts.get(p);
    }
}
