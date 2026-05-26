package com.cafeapp.utils;

import com.cafeapp.interfaces.Displayable;

public class ListUtils {

    public static <T extends Enum<T> & Displayable> void genericMenuDisplay(T[] values){
        for (T value : values) {
            System.out.printf(
                    "%-1d ) %s%n",
                    value.getCode(),
                    value.getLabel()
            );
        }
    }

//    public static <T extends Enum<T> & Displayable> void menuDisplayWithPrices(T[] values){
//        for (T value : values) {
//            System.out.printf(
//                    "%-1d ) %s%n-1d %f",
//                    value.getCode(),
//                    value.getLabel(),
//            );
//        }
//    }
}
