package com.example.paymentta.controller;

import com.example.paymentta.dto.TransactionDto;

import com.example.paymentta.entity.Transaction;
import com.example.paymentta.exceptions.ServiceException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends AbstractController<Transaction , TransactionDto>{

//    @Override
//    @PostMapping("/cardToCard")
//    public void add(@RequestBody TransactionDto transaction) throws ServiceException {
//        super.add(transaction);
//    }




    @PostMapping("/get")
    public void getTrx(@RequestBody TransactionDto trx) {

//        transactionService.getTransactions(trx.getReceiver().getCardNumber(),
//                trx.getSender().getCardNumber(),
//                trx.getDate(),
//                trx.getDate());
    }


}
