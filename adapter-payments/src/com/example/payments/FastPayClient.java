package com.example.payments;

import java.util.Random;

public class FastPayClient {
    public String makePayment(String user, int cents) {
        Random rand = new Random();
        int randomId = rand.nextInt(100000);
        return "FASTPAY-" + randomId;
    }
}
