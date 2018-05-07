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
    private ProductStock productStock;
    private CoinStock coinStock;
    private CoinStock coinsInserted;

    private static final int DEFAULT_STOCK_COUNT = 10;

    public VendingMachine(){
        this(new ProductStock(DEFAULT_STOCK_COUNT), new CoinStock(DEFAULT_STOCK_COUNT));
    }

    public VendingMachine(ProductStock initialStock) {
        this(initialStock, new CoinStock(DEFAULT_STOCK_COUNT));
    }

    public VendingMachine(CoinStock initialStock) {
        this(new ProductStock(DEFAULT_STOCK_COUNT),initialStock);
    }

    public VendingMachine(ProductStock initialProducts, CoinStock initialCoins){
        totalInserted=0;
        productSelected=false;
        productDisplay="";
        this.productStock = initialProducts;
        this.coinStock = initialCoins;
        coinsInserted = new CoinStock(0);
    }

    public String readDisplay(){
        if(productSelected){
            productSelected = false;
            return productDisplay;
        }
        if(this.totalInserted>0){
            return String.format("%.2f",(float)totalInserted/100);
        }
        if(exactChangeNeeded()){
            return "EXACT CHANGE ONLY";
        }
        return "INSERT COIN";
    }

    private boolean exactChangeNeeded() {
        //Cannot make 5 cent change
        if(coinStock.getCount(Coin.NICKEL)<=0)
            return true;
        //Cannot make 10 cent change
        if(coinStock.getCount(Coin.NICKEL)<2 && coinStock.getCount(Coin.DIME)<=0)
            return true;
        //Cannot make 15 cent change
        if(coinStock.getCount(Coin.DIME)<=0 && coinStock.getCount(Coin.NICKEL)<3
                || coinStock.getCount(Coin.DIME)>=1 && coinStock.getCount(Coin.NICKEL)<=0)
            return true;
        //Cannot make 20 cent change
        if(coinStock.getCount(Coin.DIME)<=0 && coinStock.getCount(Coin.NICKEL)<4
                || coinStock.getCount(Coin.DIME)==1 && coinStock.getCount(Coin.NICKEL)<2)
            return true;
        return false;
    }

    public Coin[] insertCoin(Coin coin) {
        Coin[] coinReturn = new Coin[]{};
        int coinValue = determineCoinValue(coin);
        if(coinValue>0){
            coinsInserted.addStock(coin,1);
            totalInserted+=coinValue;
        } else {
            coinReturn = new Coin[] {coin};
        }
        return coinReturn;
    }

    public Coin[] selectProduct(Product product) {
        Coin[] coinReturn = new Coin[]{};
        productSelected = true;
        if(productStock.getCount(product)<=0){
            productDisplay = "SOLD OUT";
        } else if(totalInserted<product.price()){
            productDisplay=String.format("PRICE %.2f",(float)product.price()/100);
        } else {
            productDisplay="THANK YOU";
            addInsertedCoinToStock();
            coinReturn = makeChange(totalInserted - product.price());
            clearInserted();
            productStock.removeStock(product,1);
        }
        return coinReturn;
    }

    private void addInsertedCoinToStock() {
        coinStock.addStock(Coin.NICKEL,coinsInserted.getCount(Coin.NICKEL));
        coinStock.addStock(Coin.DIME,coinsInserted.getCount(Coin.DIME));
        coinStock.addStock(Coin.QUARTER,coinsInserted.getCount(Coin.QUARTER));
    }

    private Coin[] makeChange(int changeTotal){
        List<Coin> coins = new ArrayList<>();
        for(Coin c: Coin.values()){
            int coinValue = determineCoinValue(c);
            if(coinValue>0) {
                int coinChange = Math.min(changeTotal / coinValue, coinStock.getCount(c));
                if(coinChange>0) {
                    changeTotal -= coinChange * coinValue;
                    coinStock.removeStock(c, coinChange);
                    for (; coinChange > 0; coinChange--) coins.add(c);
                }
            }
        }
        return coins.toArray(new Coin[0]);
    }

    private int determineCoinValue(Coin c) {
        if(c.diameter()==24.3 && c.mass()==5.6){
            return 25;
        } else if(c.mass()==2.3 && c.diameter()==17.9){
            return 10;
        } else if(c.mass()==5.0 && c.diameter()==21.2){
            return 5;
        } else {
            return 0;
        }
    }

    public Coin[] returnCoins() {
        List<Coin> returnCoins = new ArrayList<Coin>();
        for(int i=0; i<coinsInserted.getCount(Coin.QUARTER); i++)
            returnCoins.add(Coin.QUARTER);
        for(int i=0; i<coinsInserted.getCount(Coin.DIME); i++)
            returnCoins.add(Coin.DIME);
        for(int i=0; i<coinsInserted.getCount(Coin.NICKEL); i++)
            returnCoins.add(Coin.NICKEL);
        clearInserted();
        return returnCoins.toArray(new Coin[0]);
    }

    private void clearInserted(){
        totalInserted = 0;
        coinsInserted = new CoinStock(0);
    }
}
