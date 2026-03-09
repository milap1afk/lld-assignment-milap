package com.example.payments;

import java.util.Random;

public class SafeCashClient {
    public String sendMoney(String accountId, int amount) {
        Random rand = new Random();
        int randomId = rand.nextInt(100000);
        return "SAFECASH-" + randomId;
    }
}
