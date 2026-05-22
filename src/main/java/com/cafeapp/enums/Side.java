package com.cafeapp.enums;

public enum Side {
    MACARON("Macaron","Included", 0),
    CAKE_POP("Cake Pop", "Included", 0),

    BUTTER_CROISSANT("Butter Croissant", "Main", 1.50);

  private final String name;
  private final String type;
  private final double price;

    Side(String name, String type , double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
