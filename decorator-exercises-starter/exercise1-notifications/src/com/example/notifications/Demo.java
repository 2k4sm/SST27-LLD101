package com.example.notifications;

/**
 * Starter demo that uses only the existing Email notifier.
 * TODOs guide you to add decorators and compose them.
 */
public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline behavior (already works)
        System.out.println("\nEmail Only");
        base.notify("Baseline email only.");

        System.out.println("\nEmail + SMS");
        Notifier emailAndSms = new SmsDecorator(base, "+91-99999-11111");
        emailAndSms.notify("notify");

        System.out.println("\nEmail + WhatsApp");
        Notifier emailAndWhatsApp = new WhatsAppDecorator(base, "user_wa");
        emailAndWhatsApp.notify("notify");

        System.out.println("\nEmail + Slack");
        Notifier emailAndSlack = new SlackDecorator(base, "notifications");
        emailAndSlack.notify("notify");

        System.out.println("\nEmail + WhatsApp + Slack");
        Notifier multiChannel = new SlackDecorator(
                new WhatsAppDecorator(base, "user_wa"),
                "deployments");
        multiChannel.notify("notify");
    }
}
