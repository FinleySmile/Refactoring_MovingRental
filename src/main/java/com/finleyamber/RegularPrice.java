package com.finleyamber;

/**
 * Created by Lpp on 2016/5/28
 */
public class RegularPrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        return daysRented > 2 ? ((daysRented - 2) * 1.5 + 2) : 2;
    }
}
