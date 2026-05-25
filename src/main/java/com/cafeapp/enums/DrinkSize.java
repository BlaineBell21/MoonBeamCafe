package com.cafeapp.enums;


import java.util.Arrays;
import java.util.Optional;

public enum DrinkSize {
    SMALL(1,"Small",3.50),
    MEDIUM(2,"Medium",9),
    LARGE(3,"Large",8.50);

    private final int code;
    private final double baseCost;
    private final String label;

    DrinkSize(int code, String drinkSize, double baseCost){
        this.code = code;
        this.baseCost = baseCost;
        this.label = drinkSize;
    }

    public int getCode() {
        return code;
    }

    public double getBaseCost(){
        return baseCost;
    }
    public String getLabel(){
        return label;
    }

    public static Optional<DrinkSize> fromCode(int code) {
        return Arrays.stream(values())
                .filter(option -> option.code == code)
                .findFirst();
    }
}
