package com.example.payments;

import java.util.Objects;

// adapter for safecash sdk to the paymentgateway interface
public class SafeCashAdapter implements PaymentGateway {
    private final SafeCashClient client;

    // inject sdk client
    public SafeCashAdapter(SafeCashClient client) {
        this.client = Objects.requireNonNull(client, "client");
    }

    @Override
    public String charge(String customerId, int amountCents) {
        // create payment then confirm to get transaction id
        Objects.requireNonNull(customerId, "customerId");
        SafeCashPayment p = client.createPayment(amountCents, customerId);
        return p.confirm();
    }
}


