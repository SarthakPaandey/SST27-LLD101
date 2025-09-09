package com.example.notifications;

public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");
        base.notify("Baseline email only.");
        Notifier emailSms = new SmsDecorator(base, "+91-99999-11111");
        emailSms.notify("build green ✅");
        Notifier emailWa = new WhatsAppDecorator(base, "user_wa");
        emailWa.notify("release tagged ✨");
        Notifier emailSlack = new SlackDecorator(base, "alerts");
        emailSlack.notify("pager quiet 😌");
        Notifier full = new SlackDecorator(new WhatsAppDecorator(base, "user_wa"), "deployments");
        full.notify("deployment completed 🚀");
    }
}
