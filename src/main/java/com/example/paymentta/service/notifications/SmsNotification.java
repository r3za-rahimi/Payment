package com.example.paymentta.service.notifications;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
public class SmsNotification implements Notification {


    @Override
    public void notifyUser(NotificationText text) {
        log.info("sms is send .. .  .\n " + text);

    }
}
