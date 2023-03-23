package com.example.paymentta.entity;

import com.example.paymentta.entity.account.Account;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Transaction extends AbstractEntity{


    private Date date;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Customer sender;

    @OneToOne
    private Account senderAccount;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Customer receiver;

    @OneToOne
    private Account receiverAccount;
    private Long amount;
}
