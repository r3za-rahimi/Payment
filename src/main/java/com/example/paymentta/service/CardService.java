package com.example.paymentta.service;

import com.example.paymentta.entity.Customer;
import com.example.paymentta.entity.account.Card;
import com.example.paymentta.repository.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService extends AbstractService<CardRepository, Card> {

    public Card getByCardNumber(String CardNumber){

      return   repository.findByCardNumber(CardNumber);

    }

}
