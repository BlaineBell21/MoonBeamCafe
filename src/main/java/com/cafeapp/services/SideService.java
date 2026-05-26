package com.cafeapp.services;

import com.cafeapp.enums.Side;
import com.cafeapp.enums.menus.SideMenuOption;
import com.cafeapp.ui.OrderScreen;
import com.cafeapp.utils.InputHelper;
import com.cafeapp.utils.ListUtils;

import java.util.ArrayList;

public class SideService {

    private static ArrayList<Side> sides = new ArrayList<>();

    public static void addSideUI(){
        sideMainMenuDisplay();
        for (Side side : sides) {
            com.cafeapp.models.Side newSide = new com.cafeapp.models.Side(side.getLabel(), side.getPrice());
            OrderScreen.getOrder().addItem(newSide);
        }
    }

    public static void getSideMainMenuOptionsUI(){
        ListUtils.genericMenuDisplay(SideMenuOption.values());
        System.out.println();
    }

    public static void sideMainMenuDisplay(){
        SideMenuOption selectedChoice;
        while (true){
            getSideMainMenuOptionsUI();
            int choice = InputHelper.readIntInput("Enter in the number of your choice: ");
            selectedChoice = SideMenuOption.fromCode(choice).orElse(null);
            if (selectedChoice != null){
                sideMainMenuOptions(selectedChoice);
                return;
            }
            System.out.println("invalid option try again");
        }
    }

    public static void sideMainMenuOptions(SideMenuOption choice){

        switch (choice){
            case COMPLIMENTARY_SIDES -> complimentarySides();
            case MAINS -> mainSidesDisplay();
            case EXIT -> {
                System.out.println("returning to previous menu");
            }
        }
    }

    public static void sidesUI(){
        for(Side option : Side.values()){
            if (option.getType().equals("Included")){
                System.out.printf("%-1d ) %s%n", option.getCode(), option.getLabel());
                System.out.println(option.getDescription());
            }
        }
        System.out.println("0) Finish");
        System.out.println();
    }

    public static void complimentarySides(){
        while (true){
            sidesUI();
            String selectedChoice = InputHelper.readStringInput("Enter the number of the side you want: ");

            switch(selectedChoice.trim()){
                case "1":
                    sides.add(Side.ORBIT_MACARON);
                    break;
                case "2":
                    sides.add(Side.GALAXY_CAKE_POP);
                    break;
                case "3":
                    sides.add(Side.STARFALL_SCONE);
                    break;
                case "4":
                    sides.add(Side.CRESCENT_MOON_CROISSANT);
                    break;
                case "5":
                    sides.add(Side.LUNAR_BLUEBERRY_MUFFIN);
                    break;
                case "0":
                    System.out.println("Returning to previous menu");
                    return;
            }
        }
    }


    public static void mainSidesDisplay(){
        while (true){
            sidesUI();
            String selectedChoice = InputHelper.readStringInput("Enter the number of the side you want: ");

            switch(selectedChoice){
                case "1":
                    sides.add(Side.ECLIPSE_LAVA_CAKE);
                    break;
                case "2":
                    sides.add(Side.GALAXY_TIRAMISU);
                    break;
                case "3":
                    sides.add(Side.LUNAR_CHEESECAKE_SLICE);
                    break;
                case "4":
                    sides.add(Side.MILKY_WAY_PARFAIT);
                    break;
                case "5":
                    sides.add(Side.METEORITE_BROWNIE);
                    break;
                case "6":
                    sides.add(Side.COSMIC_CINNAMON_ROLL);
                    break;
                case "0":
                    System.out.println("Returning to previous menu");
                    return;
            }
        }
    }
    public static ArrayList<Side> getSides(){
        return sides;
    }
}
