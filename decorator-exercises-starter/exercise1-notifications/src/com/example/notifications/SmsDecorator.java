package com.example.notifications;

public class SmsDecorator extends NotifierDecorator {
    private final String phone;

    public SmsDecorator(Notifier next, String phone) {
        super(next);
        this.phone = phone;
    }

    @Override
    public void notify(String text) {
        System.out.println("[SMS -> " + phone + "]: " + text);
        next.notify(text);
    }
}


