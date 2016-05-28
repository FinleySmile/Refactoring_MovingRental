package com.finleyamber;

/**
 * Created by Lpp on 2016/5/28
 */
public abstract class Price {
    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return  1;
    }

}
