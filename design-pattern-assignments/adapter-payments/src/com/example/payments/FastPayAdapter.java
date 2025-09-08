package com.example.payments;

import java.util.Objects;

// adapter for fastpay sdk to the paymentgateway interface
public class FastPayAdapter implements PaymentGateway {
    private final FastPayClient client;

    // inject sdk client
    public FastPayAdapter(FastPayClient client) {
        this.client = Objects.requireNonNull(client, "client");
    }

    @Override
    public String charge(String customerId, int amountCents) {
        // map call to sdk method
        Objects.requireNonNull(customerId, "customerId");
        return client.payNow(customerId, amountCents);
    }
}


