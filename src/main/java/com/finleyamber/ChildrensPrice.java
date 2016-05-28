package com.finleyamber;

/**
 * Created by Lpp on 2016/5/28
 */
public class ChildrensPrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        return daysRented > 3 ? (daysRented - 3) * 1.5 + 1.5 : 1.5;
    }
}
