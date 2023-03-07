package com.example.paymentta.service.notifications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class NotificationText {

    private String text;
    private String cardNumber;
    private Long amount;
    private Date date;

}
