package com.texel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacob on 5/4/2018.
 */
public class VendingMachine {
    private int totalInserted;
    private boolean productSelected;
    private String productDisplay;

    public VendingMachine(){
        totalInserted=0;
        productSelected =false;
        productDisplay="";
    }

    public String readDisplay(){
        if(productSelected){
            productSelected = false;
            return productDisplay;
        }
        if(this.totalInserted>0){
            return String.format("%.2f",(float)totalInserted/100);
        }
        return "INSERT COIN";
    }

    public Coin[] insertCoin(Coin coin) {
        Coin[] coinReturn = new Coin[]{};
        if(coin.equals(Coin.QUARTER)){
            totalInserted+=25;
        } else if(coin.equals(Coin.DIME)){
            totalInserted+=10;
        } else if(coin.equals(Coin.NICKEL)){
            totalInserted+=5;
        } else {
            coinReturn = new Coin[] {coin};
        }
        return coinReturn;
    }

    public Coin[] selectProduct(Product product) {
        Coin[] coinReturn = new Coin[]{};
        this.productSelected = true;
        if(totalInserted<product.price()){
            productDisplay=String.format("%.2f",(float)product.price()/100);
        } else {
            productDisplay="THANK YOU";
            coinReturn = makeChange(totalInserted - product.price());
            totalInserted = 0;
        }
        return coinReturn;
    }

    private Coin[] makeChange(int difference){
        List<Coin> coins = new ArrayList<>();
        System.out.println(difference);
        while(difference>=25){
            coins.add(Coin.QUARTER);
            difference-=25;
        }
        while(difference>=10){
            coins.add(Coin.DIME);
            difference-=10;
        }
        if(difference>=5){
            coins.add(Coin.NICKEL);
        }
        return coins.toArray(new Coin[0]);
    }
}
