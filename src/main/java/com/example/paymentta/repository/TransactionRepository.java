package com.example.paymentta.repository;

import com.example.paymentta.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction , Long> {


    //List<Transaction> findBySenderCardNumberOrRecieverCardNumberAndDateBetween(String card ,String card2 , Date start , Date end);



}
