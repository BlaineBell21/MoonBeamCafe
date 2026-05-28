package com.cafeapp.utils;

import com.cafeapp.models.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    public static void receiptWriter(Order order) throws IOException {


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/receipts"))) {
            String writeOrders = order.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
