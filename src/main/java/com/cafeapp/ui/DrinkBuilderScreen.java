package com.cafeapp.ui;

import com.cafeapp.enums.DrinkSize;
import com.cafeapp.enums.ToppingType;
import com.cafeapp.models.Drink;
import com.cafeapp.utils.InputHelper;

import java.util.ArrayList;

public class DrinkBuilderScreen {

    private static ArrayList<ToppingType> toppings = new ArrayList<>();

    public static void addDrinkUI(){
        System.out.println("Start by selecting your drink size: ");
        DrinkSize size = orderDrinkDisplay();
        orderToppingDisplay();
    }

    public static void drinkSizeUI(){
        for(DrinkSize option : DrinkSize.values()){
            System.out.printf("%-3d - %s%n", option.getCode(), option.getLabel());
        }
        System.out.println();
    }

    public static DrinkSize orderDrinkDisplay(){

        System.out.println("drink screen");
        DrinkSize selectedChoice;
        while (true){
            drinkSizeUI();
            int choice = InputHelper.readIntInput("Enter in the number of your choice: ");
            selectedChoice = DrinkSize.fromCode(choice).orElse(null);
            selectedChoice = drinkSizeOptions(selectedChoice);
            if (selectedChoice != null) {
                return selectedChoice;
            }
            System.out.println("Invalid choice, try again.");
        }
    }

    public static DrinkSize drinkSizeOptions(DrinkSize choice){
        if(choice == null){
            System.out.println("Invalid Option. Please try again.");
            return choice;
        }
        while (true){
            switch(choice) {
                case SMALL:
                    return DrinkSize.SMALL;
                case MEDIUM:
                    return DrinkSize.MEDIUM;
                case LARGE:
                    return DrinkSize.LARGE;
            }
        }
    }

    public static void orderToppingDisplay(){
       toppingType();

    }

    public static void chooseToppingTypeUI(){
        System.out.println("Choose which premium, booster, or regular topping you'd like to add.\n" +
                "1) Premium\n" +
                "2) Regular\n" +
                "3) Booster");
    }

    public static void toppingType(){
        while (true){
            chooseToppingTypeUI();
            String selectedChoice = InputHelper.readStringInput("Enter in the number of your choice:");
            switch(selectedChoice.trim()) {
                case "1":
                    premiumToppings();
                    return;
                case "2":
                    regularToppings();
                    return;
                case "3":
                    boosterToppings();
                    return;
            }
        }
    }
    public static void premiumToppingUI(){
        for(ToppingType option : ToppingType.values()){
            if (option.getType().equals("Premium")){
                System.out.printf("%-3d - %s%n", option.getCode(), option.getLabel());
            }
        }
        System.out.println("0) Finish");
        System.out.println();
    }

    public static void premiumToppings(){

        while(true){
            premiumToppingUI();
            String selectedChoice = InputHelper.readStringInput("Enter the number of one of the following toppings: ");

            switch(selectedChoice.trim()){
                case "1":
                    toppings.add(ToppingType.BOBA_PEARLS);
                case "2":
                    toppings.add(ToppingType.CHEESE_FOAM);
                case "3":
                    toppings.add(ToppingType.MATCHA_FOAM);
                case "4":
                    toppings.add(ToppingType.OREO_COOKIE_CRUMBLE);
                case "0":
                    System.out.println("Returning to previous menu");
                    return;
            }
        }
    }

    public static void boosterToppings(){

    }
    public static void regularToppings(){

    }
    public static void addItems(){
        System.out.println("add item");
    }
    public static void addSignatureDrink(){
        System.out.println("add sig");
    }
    public static void addSide(){
        System.out.println("add side");
    }
}
