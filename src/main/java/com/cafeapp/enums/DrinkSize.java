package com.cafeapp.enums;

public enum DrinkSize {
    SMALL("Small",3.50),
    MEDIUM("Medium",9),
    LARGE("Large",8.50);

    private final double baseCost;
    private final String drinkSize;

    DrinkSize(String drinkSize, double baseCost){
        this.baseCost = baseCost;
        this.drinkSize = drinkSize;
    }

    public double getBaseCost(){
        return baseCost;
    }
    public String getDrinkSize(){
        return drinkSize;
    }
}
