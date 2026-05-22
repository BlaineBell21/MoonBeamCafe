package com.cafeapp.enums;

public enum DrinkType {
    LATTE("Latte"),
    ESPRESSO("Espresso"),
    BLACK_TEA("Black Tea"),
    GREEN_TEA("Green Tea");

    private final String name;

    DrinkType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
