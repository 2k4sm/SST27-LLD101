package com.example.notifications;

public class SlackDecorator extends NotifierDecorator {
    private final String channel;

    public SlackDecorator(Notifier wrappedNotifier, String channel) {
        super(wrappedNotifier);
        this.channel = channel;
    }

    @Override
    public void notify(String text) {
        System.out.println("[SLACK -> #" + channel + "]: " + text);

        super.notify(text);
    }
}
