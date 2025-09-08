package com.example.payments;

// third-party fastpay sdk client
public class FastPayClient {
    public String payNow(String custId, int amountCents) {
        return "FP#"+ custId + ":" + amountCents;
    }
}
