package com.example.paymentta.dto;

import lombok.Data;

@Data
public class TransactionDto {

    private Long id;
    private String source;
    private String destination;
    private Long amount;


    private TransactionType type;

}
