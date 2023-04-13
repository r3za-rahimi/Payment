package com.example.paymentta.entity.account;

import com.example.paymentta.entity.AbstractEntity;
import com.example.paymentta.entity.Customer;
import com.example.paymentta.entity.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@NoArgsConstructor
public class Account extends AbstractEntity {



    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long accountNumber;
    private Long balance;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne(targetEntity = Card.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Card card;


    @OneToMany(targetEntity = Transaction.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private List<Transaction> transactions;
}
