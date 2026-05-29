package com.cafeapp.utils;

import com.cafeapp.models.Order;

import java.io.*;

public class FileUtils {
    public static void receiptWriter(Order order){
        // writes new receipts to file
        String fileName = DateUtils.currentDateAndTime() + ".txt";
        // file name gets created in "yyyyMMdd-hhmmss.txt" format
        File folder = new File("src/main/java/data/receipts");
        // paths to the receipt file in the data file
        if(!folder.exists()){
            // informs user that directory is missing if not found
            System.out.println( "Missing directory: "+ folder.getName());
            if (folder.mkdirs()){
                // creates missing directories
                System.out.println("Directories created");
            } else {
                System.out.println("Failed to create receipts folder.");
            }
        }

        File file = new File(folder, fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
           writer.write(order.toReceiptString());
           // writes order to new receipt txt file

        } catch(IOException e){
            throw new RuntimeException("Unable to write to directory.");
        }
        System.out.println("Receipt created");
    }
}
