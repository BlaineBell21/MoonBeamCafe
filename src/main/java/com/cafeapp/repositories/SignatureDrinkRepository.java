package com.cafeapp.repositories;

import com.cafeapp.models.SignatureDrink;

import java.util.ArrayList;
import java.util.List;

public class SignatureDrinkRepository {
    public static void signatureDrinks(){
        ArrayList<String> lunarLatteToppings = new ArrayList<>(List.of("Vanilla Syrup","Lavendar Syrup","Cinnamon Powder"));
        SignatureDrink lunarLatte = new com.cafeapp.models.SignatureDrink("Latte", "Whole Milk",lunarLatteToppings, "A soft, calming lavender vanilla latte inspired by moonlight.");
    }
}
