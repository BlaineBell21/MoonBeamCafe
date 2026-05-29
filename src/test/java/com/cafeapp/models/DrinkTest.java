package com.cafeapp.models;

import com.cafeapp.enums.drink.DrinkBase;
import com.cafeapp.enums.drink.DrinkSize;
import com.cafeapp.enums.drink.DrinkSpecialization;
import com.cafeapp.enums.drink.topping.ToppingType;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {
// tests whether extra premium cost is properly calculated
    @org.junit.jupiter.api.Test
    void calculatePrice_ExtraPremiumToppingCost() {
        // Arrange
        ArrayList<ToppingType> toppings = new ArrayList<>();

        toppings.add(ToppingType.BOBA_PEARLS);
        toppings.add(ToppingType.CHEESE_FOAM);

        Drink drink = new Drink(
                "Galaxy Latte",
                0,
                DrinkSize.SMALL,
                DrinkBase.LATTE,
                toppings,
                DrinkSpecialization.GALAXY_SWIRL
        );

        // Act
        double totalPrice = drink.calculatePrice();

        // Assert
        assertEquals(4.55, totalPrice);

    }
}