package com.example.paymentta.dto;

import com.example.paymentta.entity.Customer;
import lombok.Data;

import java.util.Date;
@Data
public class TransactionDto   {

    private Long id;
    private String sender;
    private String receiver;
    private Long amount;
}
