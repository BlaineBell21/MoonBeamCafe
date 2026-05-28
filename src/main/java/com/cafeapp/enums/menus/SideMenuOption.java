package com.cafeapp.enums.menus;

import com.cafeapp.interfaces.Displayable;

import java.util.Arrays;
import java.util.Optional;

public enum SideMenuOption implements Displayable {
    // enum for side menu option values
    COMPLIMENTARY_SIDES(1, "Complimentary Sides"),
    MAINS(2, "Mains"),
    EXIT(3, "Exit");

    private final int code;
    private final String label;

    SideMenuOption(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
    public static Optional<SideMenuOption> fromCode(int code) {
        //takes in int input to check if it is a value that exists in the enums
        return Arrays.stream(values())
                .filter(option -> option.code == code)
                .findFirst();
    }
}
