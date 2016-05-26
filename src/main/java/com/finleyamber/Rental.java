package com.finleyamber;

import lombok.Getter;

/**
 * Author: Finley Amber
 * DateTime  : 2016/5/26 22:18
 * Description :
 */

public class Rental {
    @Getter
    private Movie movie;

    @Getter
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }
}
