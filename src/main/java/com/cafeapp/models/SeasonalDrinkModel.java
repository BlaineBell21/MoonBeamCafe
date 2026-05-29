package com.cafeapp.models;

import com.cafeapp.enums.drink.SeasonalDrink;
import com.cafeapp.enums.drink.SeasonalDrinkSize;

public class SeasonalDrinkModel extends MenuItem{
    private final SeasonalDrinkSize size;
    private final SeasonalDrink category;
    public SeasonalDrinkModel(String itemLabel, double basePrice, SeasonalDrinkSize size, SeasonalDrink category) {
        super(itemLabel, basePrice);
        this.size = size;
        this.category = category;
    }

    public String getSizeLabel() {
        return size.getLabel();
    }

    public String getCategory() {
        return category.getCategory();
    }
    public String getDrinkLabel(){
        return category.getLabel();
    }

    @Override
    double calculatePrice() {
        return size.getBaseCost();
    }

    @Override
    public String toString(){
        //formatting for drink object
        return String.format(
                """
                Name: %s
                Size: %s
                Type: %s
                $%.2f
                """,
                getDrinkLabel(),
                getSizeLabel(),
                getCategory(),
                calculatePrice()
        );
    }
}
