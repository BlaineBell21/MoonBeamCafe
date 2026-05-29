package com.cafeapp.utils;

public class UIHelper {
    private static final String BORDER = "========================================";
    private static final String DIVIDER = "\u001B[35m✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦\u001B[0m";

    private static void gradientLine(String color1, String color2, int width) {
        String block = "█".repeat(width);

        System.out.println(color1 + block + "\u001B[0m");
        System.out.println(color2 + block + "\u001B[0m");
    }

    public static void printGradientHeader(String title) {
        printGradientHeader(title, "");
    }

    public static void printGradientHeader(String title, String flavorText) {
        int width = 60;

        System.out.println();

        gradientLine("\u001B[35m", "\u001B[36m", width);
        printCentered("🌙 " + title + " ☕", width, "\u001B[36m");

        if(flavorText != null && !flavorText.isEmpty()){
            printCentered("✨ " + flavorText + " ✨", width, "\u001B[33m");
        }
        gradientLine("\u001B[36m", "\u001B[35m", width);

        System.out.println();
    }

    public static void printHeader(String title) {
        printHeader(title, "");
    }

    public static void printHeader(String title, String flavorText) {
        System.out.println("\n" + Color.PURPLE +  BORDER  + Color.RESET);
        System.out.println(Color.BOLD + "   🌙 " + title + " ☕"  + Color.RESET);

        if(flavorText != null && !flavorText.isEmpty()){
            System.out.println(Color.CYAN + "✨ " + flavorText + " ✨" + Color.RESET);
        }
        System.out.println(Color.PURPLE +  BORDER  + Color.RESET + "\n");
    }
    public static void printCentered(String text, int width, String color) {
        int padding = (width - text.length()) / 2;

        if (padding < 0) padding = 0;

        String spaces = " ".repeat(padding);

        System.out.println(color + spaces + text + Color.RESET);
    }

    public static void printSeparator(){
        System.out.println("\u001B[35m✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦\u001B[0m");
    }

    public static void printDivider() {
        System.out.println(DIVIDER);
    }

    public static void printBorder(){
        System.out.println(BORDER);
    }

    public static void printPrompt(String message) {
        System.out.print("👉 " + message);
    }

    public static void printError(String message) {
        System.out.println(Color.RED + "⚠ " + message + Color.RESET +"\n");
    }

    public static void printSuccess(String message) {
        System.out.println(Color.GREEN + "✔ " + message +  Color.RESET + "\n");
    }

    public static void printMenuTitle(String title) {
        System.out.println("🌌 " + title);
        System.out.println(DIVIDER);
    }
}
