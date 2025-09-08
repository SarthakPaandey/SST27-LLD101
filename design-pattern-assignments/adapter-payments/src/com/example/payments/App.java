package com.example.payments;

import java.util.HashMap;
import java.util.Map;

// app wires payment adapters and executes sample charges
public class App {
    public static void main(String[] args) {
        // registry of gateways by provider key
        Map<String, PaymentGateway> gateways = new HashMap<>();
        gateways.put("fastpay", new FastPayAdapter(new FastPayClient())); // adapter for fastpay
        gateways.put("safecash", new SafeCashAdapter(new SafeCashClient())); // adapter for safecash
        OrderService svc = new OrderService(gateways);

        // delegate to selected gateway without provider-specific branching
        String id1 = svc.charge("fastpay", "cust-1", 1299);
        String id2 = svc.charge("safecash", "cust-2", 1299);
        System.out.println(id1);
        System.out.println(id2);
    }
}
