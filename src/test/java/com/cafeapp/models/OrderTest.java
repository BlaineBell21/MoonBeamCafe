package com.cafeapp.models;

import com.cafeapp.enums.drink.DrinkBase;
import com.cafeapp.enums.drink.DrinkSize;
import com.cafeapp.enums.drink.DrinkSpecialization;
import com.cafeapp.enums.drink.topping.ToppingType;
import com.cafeapp.enums.side.SideType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
// tests if order totals properly calculate
class OrderTest {

    @Test
    void calculateTotalPrice() {
        // Arrange
        Order order = new Order();

        ArrayList<ToppingType> toppings = new ArrayList<>();
        toppings.add(ToppingType.BOBA_PEARLS);

        Drink drink = new Drink(
                "Moon Latte",
                0,
                DrinkSize.SMALL,
                DrinkBase.LATTE,
                toppings,
                DrinkSpecialization.NONE
        );

        Side side = new Side(
                "Crescent Moon Croissant",
                1.50,
                SideType.CRESCENT_MOON_CROISSANT.getCategory()
        );

        order.addItem(drink);
        order.addItem(side);

        // Act
        double totalPrice = order.calculateTotalPrice();

        // Assert
        assertEquals(5.75, totalPrice);
    }
}