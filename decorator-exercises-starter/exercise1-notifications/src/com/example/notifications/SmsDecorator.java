package com.example.notifications;

public class SmsDecorator extends NotifierDecorator {
    private final String phoneNumber;

    public SmsDecorator(Notifier wrappedNotifier, String phoneNumber) {
        super(wrappedNotifier);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notify(String text) {
        System.out.println("[SMS -> " + phoneNumber + "]: " + text);

        super.notify(text);
    }
}
