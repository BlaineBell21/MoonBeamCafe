package com.cafeapp.enums.side;

public enum SideCategory {
    // enum for side categories and prices
    COMPLIMENTARY(0),
    MAIN(1.50);

    private final double price;

    SideCategory(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
