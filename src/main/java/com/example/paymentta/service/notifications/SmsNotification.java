package com.example.paymentta.service.notifications;

public class SmsNotification implements Notification {


    @Override
    public void notifyUser(NotificationText text) {
        System.out.println("sms is send .. .  .\n " + text);
    }
}
