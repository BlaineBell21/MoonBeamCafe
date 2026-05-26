package com.cafeapp.models;

import java.util.ArrayList;

public class SignatureDrink {
    private final String base;
    private final String milk;
    private final ArrayList<String> ingredients;
    private final String description;

    public SignatureDrink(String base, String milk, ArrayList<String> ingredients, String description) {
        this.base = base;
        this.milk = milk;
        this.ingredients = ingredients;
        this.description = description;
    }

    public String getBase() {
        return base;
    }

    public String getMilk() {
        return milk;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }
}
