package com.example.payments;

// value returned by safecash sdk representing a pending payment
public class SafeCashPayment {
    private final int amount; 
    private final String user;
    public SafeCashPayment(int amount, String user){ this.amount = amount; this.user = user; }
    // confirm returns a transaction id
    public String confirm(){ return "SC#pay(" + user + "," + amount + ")"; }
}
