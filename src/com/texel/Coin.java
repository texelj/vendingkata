package com.texel;

/**
 * Created by jacob on 5/4/2018.
 */
public enum Coin {
    QUARTER (5.6,24.3), DIME(2.3, 17.9);

    //grams
    private final double mass;
    //millimeters
    private final double diameter;
    Coin(double mass, double diameter) {
        this.mass = mass;
        this.diameter = diameter;
    }
    public final double mass() { return mass; }
    public final double diameter() { return diameter; }
}
