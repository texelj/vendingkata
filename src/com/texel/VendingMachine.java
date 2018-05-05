package com.texel;

/**
 * Created by jacob on 5/4/2018.
 */
public class VendingMachine {
    private double totalInserted;
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
            return String.format("%.2f",totalInserted);
        }
        return "INSERT COIN";
    }

    public Coin[] insertCoin(Coin coin) {
        Coin[] coinReturn = new Coin[]{};
        if(coin.equals(Coin.QUARTER)){
            totalInserted+=.25;
        } else if(coin.equals(Coin.DIME)){
            totalInserted+=.10;
        } else if(coin.equals(Coin.NICKEL)){
            totalInserted+=.05;
        } else {
            coinReturn = new Coin[] {coin};
        }
        return coinReturn;
    }

    public void selectProduct(Product product) {
        productSelected = true;
        if(totalInserted<product.price()){
            productDisplay=String.format("%.2f",product.price());
        } else {
            productDisplay="THANK YOU";
            totalInserted = 0;
        }
    }
}
