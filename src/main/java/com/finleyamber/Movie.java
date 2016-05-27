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
    @Setter
    private int             priceCode;

    public Movie() {}

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }
}
