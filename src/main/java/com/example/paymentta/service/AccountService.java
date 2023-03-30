package com.example.paymentta.service;

import com.example.paymentta.entity.account.Account;
import com.example.paymentta.entity.account.Card;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.repository.AccountRepository;
import com.example.paymentta.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService<AccountRepository, Account> {

    @Autowired
    private CardService cardService;


    public Account withdraw(Account c, Long amount) throws ServiceException {

        if (c != null && amount < c.getBalance()) {

            c.setBalance(c.getBalance() - amount);
            repository.save(c);

            return c;

        }
        return null;
    }

    public Account deposit(Account c, Long amount) throws ServiceException {

        if (c != null) {

            c.setBalance(c.getBalance() + amount);
            repository.save(c);
            return c;

        }
        return null;
    }

    public Account getByAccount(String cardNumber) {


        return repository.findByCard_CardNumber(cardNumber);

    }


}
