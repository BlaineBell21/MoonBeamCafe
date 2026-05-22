package com.cafeapp.utils;

import java.util.Scanner;

public class InputHelper {
     static Scanner input = new Scanner(System.in);

    public static String readStringInput(String prompt){
        return input.nextLine();
    }

    public static int readIntInput(String prompt){
        return input.nextInt();
    }
}
