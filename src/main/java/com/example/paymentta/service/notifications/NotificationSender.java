package com.example.paymentta.service.notifications;

import com.example.paymentta.entity.Transaction;
import org.springframework.stereotype.Service;

@Service
public class NotificationSender {


    public void send(NotificationType type , NotificationText text){

        switch (type){


            case SMS -> new SmsNotification().notifyUser(text);
            case MAIL -> new EmailNotification().notifyUser(text);
            case PUSH -> new PushNotification().notifyUser(text);

        }

    }


}
