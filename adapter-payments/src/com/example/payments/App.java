package com.example.payments;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        FastPayClient fastPayClient = new FastPayClient();
        SafeCashClient safeCashClient = new SafeCashClient();

        PaymentGateway fastPayAdapter = new FastPayAdapter(fastPayClient);
        PaymentGateway safeCashAdapter = new SafeCashAdapter(safeCashClient);

        Map<String, PaymentGateway> registry = new HashMap<>();
        registry.put("fastpay", fastPayAdapter);
        registry.put("safecash", safeCashAdapter);

        System.out.println("Processing payment with FastPay...");
        PaymentGateway fastPay = registry.get("fastpay");
        OrderService firstOrder = new OrderService(fastPay);
        String tx1 = firstOrder.processOrder("user123", 5000);
        System.out.println("Transaction ID: " + tx1);
        System.out.println();

        System.out.println("Processing payment with SafeCash...");
        PaymentGateway safeCash = registry.get("safecash");
        OrderService order2 = new OrderService(safeCash);
        String tx2 = order2.processOrder("user999", 3000);
        System.out.println("Transaction ID: " + tx2);
    }
}
