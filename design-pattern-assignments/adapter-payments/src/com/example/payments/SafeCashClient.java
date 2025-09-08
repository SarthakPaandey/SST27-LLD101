package com.example.payments;

// third-party safecash sdk client
public class SafeCashClient {
    public SafeCashPayment createPayment(int amount, String user) {
        return new SafeCashPayment(amount, user);
    }
}
