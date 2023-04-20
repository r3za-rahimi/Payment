package com.example.paymentta.dto;

import com.example.paymentta.entity.AbstractEntity;
import com.example.paymentta.entity.Customer;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.entity.account.AccountType;
import com.example.paymentta.entity.account.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto extends AbstractDto {



    private AccountType accountType;
    private Long accountNumber;
    private Long balance;
    private CustomerDto customer;
    private CardDto card;
    private List<TransactionDto> transactions;
}
