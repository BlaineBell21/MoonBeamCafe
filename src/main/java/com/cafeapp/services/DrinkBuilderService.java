package com.cafeapp.services;

import com.cafeapp.enums.drink.DrinkSize;
import com.cafeapp.enums.drink.DrinkBase;
import com.cafeapp.enums.drink.DrinkSpecialization;
import com.cafeapp.enums.topping.ToppingCategory;
import com.cafeapp.enums.topping.ToppingType;
import com.cafeapp.models.Drink;
import com.cafeapp.ui.OrderScreen;
import com.cafeapp.utils.InputHelper;
import com.cafeapp.utils.ListUtils;

import java.util.ArrayList;

public class DrinkBuilderService {

    private static ArrayList<ToppingType> toppings = new ArrayList<>();
    // array that stores user's toppings

    public static void addDrinkUI(){
        DrinkSize size = drinkSizeDisplay();
        DrinkBase type = drinkBaseDisplay();
        toppingType();
        DrinkSpecialization specialization = itemSpecializationDisplay();
        Drink newDrink = new Drink(type.getLabel(),size.getBaseCost(),size,type, toppings, specialization);
        // creates a new drink object that stores the drink label (name),
        // base cost (based on cup size), size of cup, type of drink and an array of toppings
        OrderScreen.getOrder().addItem(newDrink);// adds new drink into order object to be stored for later
    }

    public static void drinkSizeUI(){
        ListUtils.genericMenuDisplay(DrinkSize.values());
        System.out.println();
    }

    public static DrinkSize drinkSizeDisplay(){
        System.out.println("Select your drink size: ");
        DrinkSize selectedChoice;
        //stores user's choice
        while (true){
            drinkSizeUI();
            int choice = InputHelper.readIntInput("Enter in the number of your choice: ");
            selectedChoice = DrinkSize.fromCode(choice).orElse(null);
            //checks if user's choice is a valid input in the DrinkSize enum otherwise returns null
            if (selectedChoice != null) {
                drinkSizeOptions(selectedChoice);
                //takes user's input to drink size options
                return selectedChoice;
            }
            System.out.println("Invalid choice, try again");
        }
    }

    public static void drinkSizeOptions(DrinkSize choice){
        //tells user what size cup was selected
        switch (choice) {
            case SMALL -> {
                System.out.println("small selected");
            }
            case MEDIUM ->{
                System.out.println("medium selected");
            }
            case LARGE ->{
                System.out.println("large selected");
            }
        }
    }

    public static void drinkBaseUI(){
        ListUtils.genericMenuDisplay(DrinkBase.values());
        // prints DrinkBase values
        System.out.println();
    }

    public static DrinkBase drinkBaseDisplay(){
        System.out.println("Select your drink base: ");
        DrinkBase selectedChoice;
        //stores user's choice
        while (true){
            drinkBaseUI();
            int choice = InputHelper.readIntInput("Enter in the number of your choice: ");
            selectedChoice = DrinkBase.fromCode(choice).orElse(null);
            //checks if user's choice is a valid input in the DrinkBase enum otherwise returns null
            if (selectedChoice != null) {
                drinkBaseOptions(selectedChoice);
                // takes user's input to drink base options
                return selectedChoice;
                // returns selected base
            }
        }
    }

    public static void drinkBaseOptions(DrinkBase choice){
        // tells user what drink base is selected
        switch (choice) {
            case LATTE -> {
                System.out.println("latte selected");
            }
            case ESPRESSO -> {
                System.out.println("espresso selected");
            }
            case BLACK_TEA -> {
                System.out.println("black tea selected");
            }
            case GREEN_TEA -> {
                System.out.println("green tea selected");
            }
        };
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
                    break;
                case "2":
                    regularToppings();
                    break;
                case "3":
                    boosterToppings();
                    break;
            }
            System.out.println("Add more toppings?");
            int choice = InputHelper.choice().getCode();
            if (choice == 2){
                //allows user choice to add different types of toppings otherwise exits topping menu
                return;
            }
        }
    }
    public static void toppingUI(ToppingCategory category){
        for(ToppingType option : ToppingType.values()){
            if (option.getCategory() == category){
                // loops through premium, regular, or booster toppings based on which is inputted
                System.out.printf("%-1d ) %s%n", option.getCode(), option.getLabel());
            }
        }
        System.out.println("0) Finish");
        System.out.println();
    }

    public static void premiumToppings(){

        while(true){
            ToppingCategory category = ToppingCategory.PREMIUM;
            //sets topping category to premium to loop through premium toppings in toppingUI
            toppingUI(category);
            String selectedChoice = InputHelper.readStringInput("Enter the number of one of the following toppings: ");

            switch(selectedChoice.trim()){
                case "1":
                    toppings.add(ToppingType.BOBA_PEARLS);
                    break;
                case "2":
                    toppings.add(ToppingType.CHEESE_FOAM);
                    break;
                case "3":
                    toppings.add(ToppingType.MATCHA_FOAM);
                    break;
                case "4":
                    toppings.add(ToppingType.OREO_COOKIE_CRUMBLE);
                    break;
                case "0":
                    System.out.println("Returning to previous menu");
                    return;
            }
        }
    }

    public static void regularToppings(){

        while(true){
            ToppingCategory category = ToppingCategory.REGULAR;
            //sets topping category to regular to loop through regular toppings in toppingUI
            toppingUI(category);
            String selectedChoice = InputHelper.readStringInput("Enter the number of one of the following toppings: ");

            switch(selectedChoice.trim()){
                case "1":
                    toppings.add(ToppingType.VANILLA_SYRUP);
                    break;
                case "2":
                    toppings.add(ToppingType.HAZELNUT_SYRUP);
                    break;
                case "3":
                    toppings.add(ToppingType.BROWN_SUGAR_SYRUP);
                    break;
                case "4":
                    toppings.add(ToppingType.LAVENDER_SYRUP);
                    break;
                case "5":
                    toppings.add(ToppingType.CARAMEL_SYRUP);
                    break;
                case "6":
                    toppings.add(ToppingType.PEPPERMINT_SYRUP);
                    break;
                case "7":
                    toppings.add(ToppingType.CINNAMON_POWDER);
                    break;
                case "8":
                    toppings.add(ToppingType.COCOA_POWDER);
                    break;
                case "9":
                    toppings.add(ToppingType.NUTMEG);
                    break;
                case "0":
                    System.out.println("Returning to previous menu");
                    return;
            }
        }
    }

    public static void boosterToppings(){

        while(true){
            ToppingCategory category = ToppingCategory.BOOSTER;
            //sets topping category to booster to loop through booster toppings in toppingUI
            toppingUI(category);
            String selectedChoice = InputHelper.readStringInput("Enter the number of one of the following toppings: ");

            switch(selectedChoice.trim()){
                case "1":
                    toppings.add(ToppingType.EXTRA_ESPRESSO_SHOT);
                    break;
                case "2":
                    toppings.add(ToppingType.ENERGY_BOOST_SYRUP);
                    break;
                case "3":
                    toppings.add(ToppingType.BLONDE_ESPRESSO_SHOT);
                    break;
                case "4":
                    toppings.add(ToppingType.NITRO_SHOT);
                    break;
                case "5":
                    toppings.add(ToppingType.PROTEIN_FOAM);
                    break;
                case "6":
                    toppings.add(ToppingType.COLLAGEN_ADD_IN);
                    break;
                case "0":
                    System.out.println("Returning to previous menu");
                    return;
            }
        }
    }

    public static void itemSpecializationUI(){
        System.out.println("Add specialization to your order: ");
        ListUtils.genericMenuDisplay(DrinkSpecialization.values());
        System.out.println();
    }

    public static DrinkSpecialization itemSpecializationDisplay(){
        //allows user to add a set specialization option to drink
        DrinkSpecialization selectedChoice;
        while(true){
            itemSpecializationUI();
            int choice = InputHelper.readIntInput("Enter in the number of your choice: ");
            selectedChoice = DrinkSpecialization.fromCode(choice).orElse(null);
            if(selectedChoice != null){
                drinkSpecializationOptions(selectedChoice);
                return selectedChoice;
            }
        }
    }

    public static void drinkSpecializationOptions(DrinkSpecialization choice){
        switch (choice) {
            case NONE -> {
                System.out.println("Standard drink preparation with no specialty enhancements.");
            }
            case MOON_FOAM -> {
                System.out.println("A smooth layer of flavored cream foam that gives the drink a soft, cloud-like finish inspired by moonlight.");
            }
            case GALAXY_SWIRL -> {
                System.out.println("A vibrant syrup swirl blended throughout the drink to create a colorful cosmic effect with extra sweetness.");
            }
            case NITRO_INFUSION -> {
                System.out.println("Infused with nitro for a creamy texture and velvety finish with a subtle sparkling sensation.");
            }
        }
    }
}
