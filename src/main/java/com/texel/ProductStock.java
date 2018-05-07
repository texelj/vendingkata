package com.texel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jacob on 5/5/2018.
 */
public class ProductStock extends Stock<Product> {

    public ProductStock(int initialStock){
        this.counts = new HashMap<Product, Integer>();
        for(Product p: Product.values()){
            this.counts.put(p, initialStock);
        }
    }
}
