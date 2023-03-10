package com.example.paymentta.controller;

import com.example.paymentta.dto.TransactionDto;

import com.example.paymentta.dto.TransactionType;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends AbstractController<Transaction , TransactionDto , TransactionService>{



    @PostMapping("/account")
    public void addA(@RequestBody TransactionDto transactionDto) throws ServiceException {

        transactionDto.setType(TransactionType.ACCOUNT);
        service.insert(converter.convertDto(transactionDto));

    }


    @Override
    @PostMapping("/card")
    public void add(@RequestBody TransactionDto transactionDto) throws ServiceException {
        transactionDto.setType(TransactionType.CARDTOCARD);
        service.insert(converter.convertDto(transactionDto));

    }

    @PostMapping("/get")
    public void getTrx(@RequestBody TransactionDto trx) {

//        transactionService.getTransactions(trx.getReceiver().getCardNumber(),
//                trx.getSender().getCardNumber(),
//                trx.getDate(),
//                trx.getDate());
    }


}
