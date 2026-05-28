package com.cafeapp.ui;

import com.cafeapp.enums.menus.Choice;
import com.cafeapp.models.Order;
import com.cafeapp.utils.InputHelper;
import com.cafeapp.utils.ListUtils;

public class CheckoutScreen {
    private static Order items = OrderScreen.getOrder();
    public static void displayOrderTotal(){
        System.out.println("Order Total: $" + items.calculateTotalPrice());
    }

    public static void confirmOrderUI(){
        ListUtils.genericMenuDisplay(Choice.values());
        System.out.println();
    }

    public static void confirmOrderDisplay(){

        Choice selectedChoice;
        do{
            System.out.println("Confirm your order?");
            items.displayOrder();
            confirmOrderUI();
            int choice = InputHelper.readIntInput("Enter in the number of your choice: ");
            selectedChoice = Choice.fromCode(choice).orElse(null);
            if (selectedChoice == Choice.YES){
                if (items.isEmpty()){
                    System.out.println("In order to check out, you must add a drink or main dish.");
                    System.out.println("Returning to previous menu.");
                    return;
                } else {
                    displayOrderTotal();
                    System.out.println("Order confirmed.\n" +
                            "Thank you for shopping at MoonBeam Cafe!");
                    return;
                }
            }
        } while (selectedChoice != Choice.NO);
        System.out.println("Returning to previous menu");
    }
    public static void cancelOrder(){
        System.out.println("Cancelling your order");
        items.clearOrder();
    }
}
