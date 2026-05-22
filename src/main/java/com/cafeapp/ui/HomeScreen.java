package com.cafeapp.ui;

import com.cafeapp.utils.InputHelper;

public class HomeScreen {
    public static void welcomeScreen(){
        System.out.println("welcome to moon beam cafe\n" +
                "would you like to place and order?");
    }

    public static void homeScreenUI(){
        System.out.println("1) place and order\n" +
                "2) exit");
    }

    public static void homeScreenOptions(){
        while (true){
            int option = InputHelper.readIntInput("Enter in the number of your choise: ");
            switch (option){

            }

        }
    }
}
