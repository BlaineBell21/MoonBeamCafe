package com.cafeapp.ui;



import com.cafeapp.enums.menus.OrderScreenOption;
import com.cafeapp.models.Drink;
import com.cafeapp.models.Order;
import com.cafeapp.utils.InputHelper;
import com.cafeapp.utils.ListUtils;

public class OrderScreen {
    private static Order currentOrder;

    public static void orderScreen(){
        System.out.println("Options: ");
    }
    public static void orderScreenUI(){
        ListUtils.genericMenuDisplay(OrderScreenOption.values());
        System.out.println();
    }

    public static void orderScreenDisplay(){
        currentOrder = new Order();
        System.out.println("order screen");
        orderScreen();
        OrderScreenOption selectedChoice;
        do{
           orderScreenUI();
           int choice = InputHelper.readIntInput("Enter in the number of your choice: ");
           selectedChoice = OrderScreenOption.fromCode(choice).orElse(null);
           orderScreenOptions(selectedChoice);
        }while (selectedChoice != OrderScreenOption.CANCEL_ORDER);
        System.out.println("Canceling Order, returning to main menu.");
    }

    public static void orderScreenOptions(OrderScreenOption choice){
        if(choice == null){
            System.out.println("Invalid Option. Please try again.");
            return;
        }
        switch(choice) {
            case ADD_ITEM:
                Drink drink = DrinkBuilderScreen.addDrinkUI();
                currentOrder.addItem(drink);
                break;
            case ADD_SEASONAL_DRINK:
                DrinkBuilderScreen.addSignatureDrink();
                break;
            case ADD_SIDE:
                DrinkBuilderScreen.addSide();
                break;
            case CHECKOUT:
                CheckoutScreen.checkout();
                break;
            case EDIT_ORDER:
            case CANCEL_ORDER:
        }

    }
}

