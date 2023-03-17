package com.example.paymentta.service;


import com.example.paymentta.entity.Customer;
import com.example.paymentta.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends AbstractService<CustomerRepository , Customer> {


    public Customer withdraw(Customer c , Long amount) {

        if (c!= null && amount < c.getBalance()) {

            c.setBalance(c.getBalance() - amount);
            super.getRepository().save(c);

            return c;

        }
        return null;
    }

    public Customer deposit(Customer c ,Long amount) {

        if (c != null) {

            c.setBalance(c.getBalance() + amount);
            super.getRepository().save(c);
            return c;

        }
        return null;
    }

    public Customer GetByCardNumber(String cardNumber) {

        Customer c =  repository.findByCardNumber(cardNumber);
        if (c!= null){

            return c;
        }
        return null;

    }

    public Customer GetByAccountNumber(String account) {

        Customer c =  repository.findByAccountNumber(account);
        if (c!= null){

            return c;
        }
        return null;

    }

}
