package com.example.paymentta.dto;

import lombok.Data;

@Data
public class TransactionDto {

    private Long id;
    private String senderCard;
    private String receiverCard;
    private String senderAccount;
    private String receiverAccount;
    private Long amount;


    private TransactionType type;

}
