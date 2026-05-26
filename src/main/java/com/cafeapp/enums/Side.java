package com.cafeapp.enums;

public enum Side {
    ORBIT_MACARON(1, "Orbit Macaron","Included", "Colorful assorted macarons inspired by planets.",0),
    GALAXY_CAKE_POP(2, "Galaxy Cake Pop", "Included", "Chocolate cake pop coated with star sprinkles.", 0),
    STARFALL_SCONE(3, "Starfall Scone", "Included", "Vanilla lavender scone with light glaze.", 0),
    CRESCENT_MOON_CROISSANT(4, "Crescent Moon Croissant", "Included", "Buttery croissant shaped like a crescent moon.", 0),
    LUNAR_BLUEBERRY_MUFFIN(5, "Lunar Blueberry Muffin", "Included", "Blueberry muffin dusted with powdered sugar \"moon dust\".", 0),

    ECLIPSE_LAVA_CAKE(1, "Eclipse Lava Cake", "Main", "Warm chocolate lava cake with dark cocoa center and powdered sugar \"stardust\".", 1.50),
    GALAXY_TIRAMISU(2, "Galaxy Tiramisu", "Main", "Espresso-soaked layered tiramisu with cocoa powder and whipped cream stars.", 1.50),
    LUNAR_CHEESECAKE_SLICE(3, "Lunar Cheesecake Slice", "Main", "Creamy vanilla cheesecake with lavender syrup glaze and cocoa dusting.", 1.50),
    MILKY_WAY_PARFAIT(4, "Milky Way Parfait", "Main", "Layered dessert cup with whipped cream, cookie crumble, caramel syrup, and boba pearls.", 1.50),
    METEORITE_BROWNIE(5, "Meteorite Brownie", "Main", "Dark chocolate brownie with Oreo crumble topping and caramel drizzle.", 1.50),
    COSMIC_CINNAMON_ROLL(6, "Cosmic Cinnamon Roll", "Main", "Large cinnamon roll with caramel drizzle.", 1.50);

    private final int code;
      private final String label;
      private final String type;
      private final String description;
      private final double price;

    Side( int code, String label, String type, String description, double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
