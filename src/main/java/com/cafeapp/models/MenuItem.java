package com.cafeapp.models;

abstract class MenuItem {
    private final String itemLabel;
    private final double basePrice;

    public MenuItem(String itemLabel, double basePrice) {
        this.itemLabel = itemLabel;
        this.basePrice = basePrice;
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public double getBasePrice() {
        return basePrice;
    }


    abstract double calculatePrice();

    @Override
    public String toString() {
        return null;
    }
}
