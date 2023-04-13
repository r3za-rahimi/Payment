package com.example.paymentta.entity;

import com.example.paymentta.entity.account.Account;
import com.example.paymentta.entity.account.DealType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends AbstractEntity{


    private Date date;
//    @ManyToOne
//    @JoinColumn(name = "sender_id")
//    private Customer sender;

    @ManyToOne(cascade = CascadeType.ALL)

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
