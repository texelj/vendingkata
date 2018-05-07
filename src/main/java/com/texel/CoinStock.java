package com.texel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jacob on 5/5/2018.
 */
public class CoinStock extends Stock<Coin> {

    public CoinStock(int initialStock){
        this.counts = new HashMap<Coin, Integer>();
        for(Coin c: Coin.values()){
            this.counts.put(c, initialStock);
        }
    }
}
