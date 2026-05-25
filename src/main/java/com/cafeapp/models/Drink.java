package com.cafeapp.models;

import java.util.List;

public class Drink {
    private final String size;
    private final String type;
    private List<Topping> toppings;

    public Drink(String size, String type, List<Topping> toppings) {
        this.size = size;
        this.type = type;
        this.toppings = toppings;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public List<Topping> getToppings() {
        return toppings;
    }
    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

}
