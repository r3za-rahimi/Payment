package com.example.paymentta.service.notifications;

public class EmailNotification implements Notification{
    @Override
    public void notifyUser(NotificationText text) {
        System.out.println("Email is send .. .  . \n " + text);

    }
}
