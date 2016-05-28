package com.finleyamber;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: Finley Amber DateTime : 2016/5/26 22:17 Description :
 */

public class Movie {
    public static final int REGULAR     = 0;
    public static final int CHILDRENS   = 1;
    public static final int NEW_RELEASE = 2;

    @Getter
    @Setter
    private String          title;

    @Getter

    private Price           price;

    public Movie() {}

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case Movie.REGULAR:
                price = new RegularPrice();
                break;
            case Movie.CHILDRENS:
                price = new ChildrensPrice();
                break;
            case Movie.NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public double getCharge(int daysRented) {
        return getPrice().getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}
