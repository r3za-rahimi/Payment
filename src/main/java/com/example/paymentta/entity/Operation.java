package com.example.paymentta.entity;

import com.example.paymentta.dto.TransactionType;
import lombok.Data;

@Data
public class Operation {

    private Long id;
    private String source;
    private String destination;
    private Long amount;
    private TransactionType type;

}
