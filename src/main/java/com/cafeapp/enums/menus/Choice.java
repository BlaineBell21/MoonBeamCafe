package com.cafeapp.enums.menus;

import com.cafeapp.interfaces.Displayable;

import java.util.Arrays;
import java.util.Optional;

public enum Choice implements Displayable {
    //reusable enums for yes or no questions
    YES(1, "Yes"),
    NO(2, "No");

    private final int code;
    private final String label;

    Choice(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public int getCode() {
        return code;
    }
    public static Optional<Choice> fromCode(int code) {
        //takes in int input to check if it is a value that exists in the enums
        return Arrays.stream(values())
                .filter(option -> option.code == code)
                .findFirst();
    }
}
