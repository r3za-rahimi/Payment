package com.example.paymentta.dto;

import com.example.paymentta.entity.AbstractEntity;
import com.example.paymentta.entity.TransactionType;
import com.example.paymentta.entity.account.Account;
import com.example.paymentta.entity.account.DealType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransactionDto extends AbstractDto {


    private Date date;
//    private AccountDto account;
    private TransactionType transactionType ;
    private Long amount;
    private DealType dealType;
}
