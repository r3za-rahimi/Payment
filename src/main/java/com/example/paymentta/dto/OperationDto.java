package com.example.paymentta.dto;

import com.example.paymentta.entity.TransactionType;
import lombok.Data;

@Data
public class OperationDto {

    private Long id;
    private String source;
    private String destination;
    private Long amount;
    private TransactionType type;

}
