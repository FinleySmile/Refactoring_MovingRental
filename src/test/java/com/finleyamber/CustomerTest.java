package com.finleyamber;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: Finley Amber
 * DateTime  : 2016/5/26 22:27
 * Description :
 */

public class CustomerTest {

    private final String AMOUNT_TIP = "Amount owed is\t%.1f";
    private final String FREQUENT_RENTAR_POINTS = "You earned\t%d frequent renter points";

    @Test
    public void testStatement() throws Exception {

        Customer customer = new Customer("Jack");

        Movie regularMovie = new Movie("美人鱼", Movie.REGULAR);
        Movie childrensMovie = new Movie("奥特曼", Movie.CHILDRENS);
        Movie newReleaseMovie = new Movie("美国队长3", Movie.NEW_RELEASE);
        Rental regularRental = new Rental(regularMovie, 3);
        Rental childrensRental = new Rental(childrensMovie, 4);
        Rental newReleaseRental = new Rental(newReleaseMovie, 2);

        /*Only Regular Move */
        customer.addRental(regularRental);
        String result = customer.statement();
        Assert.assertTrue(result.contains(String.format(AMOUNT_TIP, 3.5)));
        Assert.assertTrue(result.contains(String.format(FREQUENT_RENTAR_POINTS, 1)));

        /*Only New Release Movie*/
        customer.getRentalList().clear();
        customer.addRental(new Rental(newReleaseMovie, 1));
        result = customer.statement();
        Assert.assertTrue(result.contains(String.format(AMOUNT_TIP, (double) 3)));
        Assert.assertTrue(result.contains(String.format(FREQUENT_RENTAR_POINTS, 1)));

        /*Only Childrens Moive*/
        customer.getRentalList().clear();
        customer.addRental(new Rental(childrensMovie, 1));
        result = customer.statement();
        Assert.assertTrue(result.contains(String.format(AMOUNT_TIP, 1.5)));
        Assert.assertTrue(result.contains(String.format(FREQUENT_RENTAR_POINTS, 1)));

        /*With All Moives*/
        customer.getRentalList().clear();
        customer.addRental(regularRental);
        customer.addRental(childrensRental);
        customer.addRental(newReleaseRental);
        result = customer.statement();
        Assert.assertTrue(result.contains(String.format(AMOUNT_TIP, 12.5)));
        Assert.assertTrue(result.contains(String.format(FREQUENT_RENTAR_POINTS, 4)));
    }


}