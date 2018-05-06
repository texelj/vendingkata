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
    private ProductStock productStock;
    private CoinStock coinStock;

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
        quarterInserted=0;
        dimeInserted=0;
        nickelInserted=0;
        totalInserted=0;
        productSelected=false;
        productDisplay="";
        this.productStock = initialProducts;
        this.coinStock = initialCoins;
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
        if(coinStock.getCoinCount(Coin.NICKEL)<=0)
            return true;
        //Cannot make 10 cent change
        if(coinStock.getCoinCount(Coin.NICKEL)<2 && coinStock.getCoinCount(Coin.DIME)<=0)
            return true;
        //Cannot make 15 cent change
        if(coinStock.getCoinCount(Coin.DIME)<=0 && coinStock.getCoinCount(Coin.NICKEL)<3
                || coinStock.getCoinCount(Coin.DIME)>=1 && coinStock.getCoinCount(Coin.NICKEL)<=0)
            return true;
        //Cannot make 20 cent change
        if(coinStock.getCoinCount(Coin.DIME)<=0 && coinStock.getCoinCount(Coin.NICKEL)<4
                || coinStock.getCoinCount(Coin.DIME)==1 && coinStock.getCoinCount(Coin.NICKEL)<2)
            return true;
        return false;
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
        if(productStock.getProductCount(product)<=0){
          productDisplay = "SOLD OUT";
        } else if(totalInserted<product.price()){
            productDisplay=String.format("%.2f",(float)product.price()/100);
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
        coinStock.addStock(Coin.NICKEL,nickelInserted);
        coinStock.addStock(Coin.DIME,dimeInserted);
        coinStock.addStock(Coin.QUARTER,quarterInserted);
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
