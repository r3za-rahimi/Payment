package com.example.paymentta.repository;


import com.example.paymentta.entity.CustomerBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerBillRepository extends JpaRepository<CustomerBill , Long> {


    CustomerBill findByMobileNumber (Integer number);
}
