package com.example.paymentta.service;
import com.example.paymentta.entity.account.Account;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService<AccountRepository, Account> {

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

    public Account getByCardNumber(String cardNumber) {


        return repository.findByCard_CardNumber(cardNumber);

    }

    public Account getByAccountNumber(String accountNumber ) {


        return repository.findByAccountNumber(accountNumber);

    }


}
