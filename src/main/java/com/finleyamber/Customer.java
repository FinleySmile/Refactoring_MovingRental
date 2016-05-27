package com.finleyamber;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Finley Amber DateTime : 2016/5/26 22:18 Description :
 */

public class Customer {
    @Getter
    private List<Rental> rentalList = new ArrayList<Rental>();
    private String       name;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentalList.add(rental);
    }

    public String statement() {
        String result = "";
        for (Rental each : rentalList) {
            result += each.getMovie().getTitle() + "\t" + each.getCharge();
        }
        result += "Amount owed is\t" + getTotalCharge();
        result += "You earned\t" + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental each : rentalList) {
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int points = 0;
        for (Rental each : rentalList) {
            points += each.getFrequentRenterPoints();
        }
        return points;
    }
}
