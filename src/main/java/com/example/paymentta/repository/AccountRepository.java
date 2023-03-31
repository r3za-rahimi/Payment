package com.example.paymentta.repository;

import com.example.paymentta.entity.account.Account;
import com.example.paymentta.entity.account.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account , Long> {


    Account findByCard_CardNumber(String card);
    Account findByAccountNumber(String accountNumber);
    }
