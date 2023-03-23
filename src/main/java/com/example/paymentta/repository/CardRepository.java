package com.example.paymentta.repository;

import com.example.paymentta.entity.account.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card , Long> {


    Card findByCardNumber(String cardNumber);
}
