package com.texel;

import java.util.Map;

/**
 * Created by jacob on 5/6/2018.
 */
abstract public class Stock <T extends Enum<T>> {
    Map<T,Integer> counts;

    public int getCount(T item){return this.counts.get(item);}

    public void addStock(T item, int add) {
        counts.put(item,counts.get(item) + add);
    }

    public void removeStock(T item, int remove) {
        counts.put(item, counts.get(item)-remove);
    }
}
