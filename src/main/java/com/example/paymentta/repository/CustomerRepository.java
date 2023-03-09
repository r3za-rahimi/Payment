package com.example.paymentta.repository;

import com.example.paymentta.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByCardNumber(String cardNumber);
    Customer findByAccountNumber(String accountNumber);

}
