package com.texel;

/**
 * Created by jacob on 5/4/2018.
 */
public class VendingMachine {
    private double totalInserted;

    public VendingMachine(){
        totalInserted=0;
    }

    public String readDisplay(){
        if(this.totalInserted>0){
            return String.format("%.2f",totalInserted);
        }
        return "INSERT COIN";
    }

    public void insertCoin(Coin coin) {
        if(coin.equals(Coin.QUARTER)){
            totalInserted+=.25;
        } else if(coin.equals(Coin.DIME)){
            totalInserted+=.10;
        } else if(coin.equals(Coin.NICKEL)){
            totalInserted+=.05;
        }
    }
}
