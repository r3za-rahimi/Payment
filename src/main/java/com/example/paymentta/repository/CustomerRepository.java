package com.example.paymentta.repository;

import com.example.paymentta.entity.Customer;
import com.example.paymentta.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    Customer findByCa(String cardNumber);
//    Customer findByAccountNumber(String accountNumber);

    Customer findByAccounts(Long id);


}
