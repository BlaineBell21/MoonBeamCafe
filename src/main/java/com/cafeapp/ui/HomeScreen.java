package com.cafeapp.ui;

import com.cafeapp.enums.menus.MainMenuOption;
import com.cafeapp.utils.InputHelper;
import com.cafeapp.utils.ListUtils;

import java.io.IOException;


public class HomeScreen {
    public static void welcomeScreen(){
        System.out.println("welcome to moon beam cafe");
    }

    public static void homeScreenUI(){
        ListUtils.genericMenuDisplay(MainMenuOption.values());
        // lists all menu option values
        System.out.println();
    }

    public static void homeScreenDisplay() throws IOException {
        MainMenuOption selectedChoice;
        // stores user's choice
        do {
            welcomeScreen();
            homeScreenUI();
            int choice = InputHelper.readIntInput("Enter in the number of your choice: ");
            selectedChoice = MainMenuOption.fromCode(choice).orElse(null);
            // validates whether the inputted choice exists, if not returns null
            homeScreenOptions(selectedChoice);
        } while(selectedChoice != MainMenuOption.EXIT);
        // continues to loop until the exit option is selected
        System.out.println("Thank you for ordering at MoonBeam Cafe");
    }

    public static void homeScreenOptions(MainMenuOption choice) throws IOException {
        // created for clarity of other developers
        switch (choice){
        case NEW_ORDER:
            OrderScreen.orderScreenDisplay();
            break;
        case EXIT:
        }
    }
}
