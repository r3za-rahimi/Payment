package com.example.paymentta.service;


import com.example.paymentta.entity.Customer;
import com.example.paymentta.entity.account.Account;
import com.example.paymentta.entity.account.AccountType;
import com.example.paymentta.entity.account.Card;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService extends AbstractService<CustomerRepository , Customer> {


    @Override
    public void insert(Customer customer) throws ServiceException {

        List<Account> accounts = new ArrayList<>();

        Card c = new Card((long) (Math.random() * 100000000000000L), (long) (Math.random() * 10000 ), getExpireTime());

        Account account = new Account(AccountType.JARI , (long) (Math.random() * 4000000000000L) ,5000000L, customer , c);
        accounts.add(account);

        customer.setAccounts(accounts);

        repository.save(customer);
    }


    public Customer getById(Long accountId) {

        Customer c =  repository.findById(accountId).get();
        if (c!= null){

            return c;
        }
        return null;

    }


    private Date getExpireTime(){

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, 3);
        return cal.getTime();
    }

}
