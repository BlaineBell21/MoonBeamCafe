package com.cafeapp.enums;

public enum ToppingType {

    EXTRA_ESPRESSO_SHOT("Extra Espesso Shot", "Booster"),
    ENERGY_BOOST_SYRUP("Energy Boost Syrup", "Booster"),
    BLONDE_ESPRESSO_SHOT("Blonde Espesso Shot", "Booster"),
    NITRO_SHOT("Nitro Shot", "Booster"),
    PROTEIN_FOAM("Protein Foam", "Booster"),
    COLLAGEN_ADD_IN("Collagen Add-in", "Booster"),

    BOBA_PEARLS("Boba Pearls", "Premium"),
    CHEESE_FOAM("Cheese Foam", "Premium"),
    MATCHA_FOAM("Matcha Foam", "Premium"),
    OREO_COOKIE_CRUMBLE("Oreo Cookie Crumble", "Premium"),

    VANILLA_SYRUP("Vanilla Syrup", "Regular"),
    HAZELNUT_SYRUP("Hazelnut Syrup", "Regular"),
    BROWN_SUGAR_SYRUP("Brown Sugar Syrup", "Regular"),
    LAVENDER_SYRUP("Lavender Syrup", "Regular"),
    CARAMEL_SYRUP("Caramel Syrup", "Regular"),
    PEPPERMINT_SYRUP("Peppermint Syrup", "Regular"),
    CINNAMON_POWDER("Cinnamon Powder", "Regular"),
    COCOA_POWDER("Cocoa Powder", "Regular"),
    NUTMEG("Nutmeg", "Regular");

    private final String name;
    private final String type;

    ToppingType(String name, String type) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


}
