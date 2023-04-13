package com.example.paymentta.service;
import com.example.paymentta.entity.account.Account;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService<AccountRepository, Account> {

    public void withdraw(Account c, Long amount) throws ServiceException {

        if ( amount > c.getBalance()) {

           throw new ServiceException("low_Balance");

        }
        c.setBalance(c.getBalance() - amount);
//        repository.save(c);


    }

    public void deposit(Account c, Long amount) throws ServiceException {

            c.setBalance(c.getBalance() + amount);
//            repository.save(c);


    }

    public Account getByCardNumber(String cardNumber) throws ServiceException{


        return repository.findByCard_CardNumber(cardNumber);

    }

    public Account getByAccountNumber(String accountNumber ) {


        return repository.findByAccountNumber(accountNumber);

    }


}
