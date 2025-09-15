package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private final String userId;

    public WhatsAppDecorator(Notifier wrappedNotifier, String userId) {
        super(wrappedNotifier);
        this.userId = userId;
    }

    @Override
    public void notify(String text) {
        System.out.println("[WHATSAPP -> " + userId + "]: " + text);

        super.notify(text);
    }
}
