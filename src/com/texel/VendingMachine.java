package com.texel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacob on 5/4/2018.
 */
public class VendingMachine {
    private int quarterInserted;
    private int dimeInserted;
    private int nickelInserted;
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
            quarterInserted++;
        } else if(coin.equals(Coin.DIME)){
            totalInserted+=10;
            dimeInserted++;
        } else if(coin.equals(Coin.NICKEL)){
            totalInserted+=5;
            nickelInserted++;
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
            clearInserted();
        }
        return coinReturn;
    }

    private Coin[] makeChange(int difference){
        List<Coin> coins = new ArrayList<>();
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

    public Coin[] returnCoins() {
        List<Coin> returnCoins = new ArrayList<Coin>();
        for(int i=0; i<quarterInserted; i++)
            returnCoins.add(Coin.QUARTER);
        for(int i=0; i<dimeInserted; i++)
            returnCoins.add(Coin.DIME);
        for(int i=0; i<nickelInserted; i++)
            returnCoins.add(Coin.NICKEL);
        clearInserted();
        return returnCoins.toArray(new Coin[0]);
    }

    private void clearInserted(){
        totalInserted = 0;
        quarterInserted = 0;
        nickelInserted = 0;
        dimeInserted = 0;
    }
}
