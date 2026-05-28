package com.cafeapp.utils;


import com.cafeapp.interfaces.Displayable;

public class ListUtils {
    //generic method for listing menu values
    public static <T extends Enum<T> & Displayable> void genericMenuDisplay(T[] values){
        // implements displayable in order to take in a generic array of values from enum classes
        for (T value : values) {
            System.out.printf(
                    "%-1d ) %s%n",
                    value.getCode(),
                    value.getLabel()
            );
        }
    }
}
