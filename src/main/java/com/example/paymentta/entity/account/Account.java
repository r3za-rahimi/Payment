package com.example.paymentta.entity.account;

import com.example.paymentta.entity.AbstractEntity;
import com.example.paymentta.entity.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account extends AbstractEntity {



    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private Long balance;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Card card;
}
