package com.texel;

/**
 * Created by jacob on 5/4/2018.
 */
public enum Product {
    COLA(100), CHIPS(50), CANDY(65);

    //Price in cents
    private final int price;
    Product(int price){
        this.price = price;
    }
    public final int price(){return price;}
}
