package com.texel;

/**
 * Created by jacob on 5/4/2018.
 */
public enum Product {
    COLA(1.00), CHIPS(0.50), CANDY(0.65);

    //Price
    private final double price;
    Product(double price){
        this.price = price;
    }
    public final double price(){return price;}
}
