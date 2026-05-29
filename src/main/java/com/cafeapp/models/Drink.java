package com.cafeapp.models;

import com.cafeapp.enums.drink.DrinkSize;
import com.cafeapp.enums.drink.DrinkBase;
import com.cafeapp.enums.drink.DrinkSpecialization;
import com.cafeapp.enums.drink.topping.ToppingCategory;
import com.cafeapp.enums.drink.topping.ToppingType;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Drink extends MenuItem{
    private final DrinkSize size;
    private final DrinkBase category;
    private final ArrayList<ToppingType> toppings;
    private final DrinkSpecialization specialization;

    public Drink(String itemLabel, double basePrice, DrinkSize size, DrinkBase category, ArrayList<ToppingType> toppings, DrinkSpecialization specialization) {
        super(itemLabel, basePrice);
        this.size = size;
        this.category = category;
        this.toppings = toppings;
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization.getLabel();
    }

    public DrinkSize getSize() {
        return size;
    }

    public double getCupBaseCost(DrinkSize size) {
        return size.getBaseCost();
    }

    public String getType() {
        return category.getLabel();
    }

    public ArrayList<ToppingType> getToppings(){
        return toppings;
    }

    public double calculateToppingTotal(){
        // method to calculate total of toppings added to a drink object
        ArrayList<ToppingType> toppings = getToppings();
        int totalPremiumToppings = 0;
        int totalBoosterToppings = 0;

        for(ToppingType topping : toppings){
            if(topping.getCategory() == ToppingCategory.PREMIUM) {
                totalPremiumToppings += 1;
            } else if(topping.getCategory() == ToppingCategory.BOOSTER){
                totalBoosterToppings += 1;
            }
        }

        double premiumToppingsPrice = 0;
        double boosterToppingsPrice = 0;

        switch(size) {
            case SMALL -> {
                if (totalPremiumToppings == 1){
                    // if there is a singular premium topping, adds base small premium price
                    premiumToppingsPrice += ToppingCategory.PREMIUM.getSmallBasePrice();
                } else if (totalPremiumToppings > 1) {
                    // if there is more than one premium topping, adds base price once
                    // then adds extra price for remainder of toppings
                    premiumToppingsPrice += ToppingCategory.PREMIUM.getSmallBasePrice();
                    int premiumToppings = totalPremiumToppings - 1;
                    premiumToppingsPrice += premiumToppings * ToppingCategory.PREMIUM.getSmallExtraPrice();
                }
                if (totalBoosterToppings == 1){
                    // if there is a singular booster topping, adds base small booster price
                    boosterToppingsPrice += ToppingCategory.BOOSTER.getSmallBasePrice();
                } else if (totalBoosterToppings > 1) {
                    // if there is more than one booster topping, adds base price once
                    // then adds extra price for remainder of toppings
                    boosterToppingsPrice += ToppingCategory.BOOSTER.getSmallBasePrice();
                    int boosterToppings = totalBoosterToppings - 1;
                    boosterToppingsPrice += boosterToppings * ToppingCategory.BOOSTER.getSmallExtraPrice();
                }
            }
            case MEDIUM -> {
                if(totalPremiumToppings == 1) {
                    // if there is a singular premium topping, adds base medium premium price
                    premiumToppingsPrice += ToppingCategory.PREMIUM.getMediumBasePrice();
                }else if (totalPremiumToppings > 1) {
                    // if there is more than one premium topping, adds base price once
                    // then adds extra price for remainder of toppings
                    premiumToppingsPrice += ToppingCategory.PREMIUM.getMediumBasePrice();
                    int premiumToppings = totalPremiumToppings - 1;
                    premiumToppingsPrice += premiumToppings * ToppingCategory.PREMIUM.getMediumExtraPrice();
                }
                if (totalBoosterToppings == 1){
                    // if there is a singular booster topping, adds base medium booster price
                    boosterToppingsPrice += ToppingCategory.BOOSTER.getMediumBasePrice();
                } else if (totalBoosterToppings > 1) {
                    // if there is more than one booster topping, adds base price once
                    // then adds extra price for remainder of toppings
                    boosterToppingsPrice += ToppingCategory.BOOSTER.getMediumBasePrice();
                    int boosterToppings = totalBoosterToppings - 1;
                    boosterToppingsPrice += boosterToppings * ToppingCategory.BOOSTER.getMediumExtraPrice();
                }
            }
            case LARGE -> {
                if(totalPremiumToppings == 1) {
                    // if there is a singular premium topping, adds base large premium price
                    premiumToppingsPrice += ToppingCategory.PREMIUM.getLargeBasePrice();
                }else if (totalPremiumToppings > 1) {
                    // if there is more than one premium topping, adds base price once
                    // then adds extra price for remainder of toppings
                    premiumToppingsPrice += ToppingCategory.PREMIUM.getLargeBasePrice();
                    int premiumToppings = totalPremiumToppings - 1;
                    premiumToppingsPrice += premiumToppings * ToppingCategory.PREMIUM.getLargeExtraPrice();
                }
                if (totalBoosterToppings == 1){
                    // if there is a singular booster topping, adds base large booster price
                    boosterToppingsPrice += ToppingCategory.BOOSTER.getLargeBasePrice();
                } else if (totalBoosterToppings > 1) {
                    // if there is more than one booster topping, adds base price once
                    // then adds extra price for remainder of toppings
                    boosterToppingsPrice += ToppingCategory.BOOSTER.getLargeBasePrice();
                    int boosterToppings = totalBoosterToppings - 1;
                    boosterToppingsPrice += boosterToppings * ToppingCategory.BOOSTER.getLargeExtraPrice();
                }
            }
        }
        return premiumToppingsPrice + boosterToppingsPrice;
    }

    public String getToppingFormat() {
        // neatly formats toppings through concatenation and returns them as a string
        return toppings.stream()
                .map(ToppingType::getLabel)
                .collect(Collectors.joining(", "));
    }

    @Override
    double calculatePrice() {
        //calculates total price of a singular drink object
        double baseCupCost = getCupBaseCost(size);
        return baseCupCost + calculateToppingTotal();
    }

    @Override
    public String toString(){
        //formatting for drink object
        return String.format(
                """
                Size: %s
                Type: %s
                Toppings: %s
                Specialization: %s
                $%.2f
                """,
                getSize(),
                getType(),
                getToppingFormat(),
                getSpecialization(),
                calculatePrice()
        );
    }

}
