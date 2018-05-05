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
}
