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
            return Double.toString(totalInserted);
        }
        return "INSERT COIN";
    }

    public void insertCoin(Coin coin) {
        if(coin.equals(Coin.QUARTER)){
            totalInserted+=.25;
        }
    }
}
