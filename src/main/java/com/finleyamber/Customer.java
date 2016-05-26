package com.finleyamber;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Finley Amber
 * DateTime  : 2016/5/26 22:18
 * Description :
 */

public class Customer {
    @Getter
    private List<Rental> rentalList = new ArrayList<Rental>();
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentalList.add(rental);
    }

    public String statement() {
        String result = "";
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        for (Rental each : rentalList) {
            double thisAmount = 0;
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
            }
            result += each.getMovie().getTitle() + "\t" + thisAmount;
            totalAmount += thisAmount;
            ++frequentRenterPoints;
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1)
                ++frequentRenterPoints;
        }
        result += "Amount owed is\t" + totalAmount;
        result += "You earned\t" + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
