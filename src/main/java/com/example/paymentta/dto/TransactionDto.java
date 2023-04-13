package com.example.paymentta.dto;

import com.example.paymentta.entity.AbstractEntity;
import com.example.paymentta.entity.account.Account;
import com.example.paymentta.entity.account.DealType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;

@Data
public class TransactionDto extends AbstractEntity {


    private Date date;
//    @ManyToOne
//    @JoinColumn(name = "sender_id")
//    private Customer sender;


    private Account account;
//    private Account senderAccount;
//    @ManyToOne
//    @JoinColumn(name = "receiver_id")
//    private Customer receiver;

    //    @OneToOne
//    private Account receiverAccount;
    private Long amount;

    @Enumerated(EnumType.STRING)
    private DealType dealType;
}
