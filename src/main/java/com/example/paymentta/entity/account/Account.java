package com.example.paymentta.entity.account;

import com.example.paymentta.entity.AbstractEntity;
import com.example.paymentta.entity.Customer;
import com.example.paymentta.entity.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
@NoArgsConstructor
public class Account extends AbstractEntity {



    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long accountNumber;
    private Long balance;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne(targetEntity = Card.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Card card;
    @OneToMany(mappedBy = "account",targetEntity = Transaction.class ,cascade = CascadeType.ALL , fetch = FetchType.EAGER)
//    @JsonIgnore
    private List<Transaction> transactions;
}
