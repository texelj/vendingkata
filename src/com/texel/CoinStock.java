package com.texel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jacob on 5/5/2018.
 */
public class CoinStock {
    private Map<Coin,Integer> coinCounts;

    public CoinStock(int initialStock){
        this.coinCounts = new HashMap<Coin, Integer>();
        for(Coin c: Coin.values()){
            this.coinCounts.put(c, initialStock);
        }
    }

    public int getCoinCount(Coin c){
        return this.coinCounts.get(c);
    }

    public void addStock(Coin c, int add) {
        coinCounts.put(c,coinCounts.get(c) + add);
    }

    public void removeStock(Coin c, int remove) {
        coinCounts.put(c, coinCounts.get(c)-remove);
    }
}
