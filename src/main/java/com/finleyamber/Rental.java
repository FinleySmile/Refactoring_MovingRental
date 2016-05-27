package com.finleyamber;

import lombok.Getter;

/**
 * Author: Finley Amber DateTime : 2016/5/26 22:18
 */

public class Rental {
    @Getter
    private Movie movie;

    @Getter
    private int   daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double getCharge() {
        double amount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (daysRented > 2) {
                    amount += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.CHILDRENS:
                amount += 1.5;
                if (daysRented > 3) {
                    amount += (daysRented - 3) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                amount += daysRented * 3;
                break;
        }
        return amount;
    }


    public int getFrequentRenterPoints() {
        return (movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) ? 2 : 1;

    }
}
