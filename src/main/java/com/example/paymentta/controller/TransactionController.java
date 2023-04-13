package com.example.paymentta.controller;

import com.example.paymentta.dto.OperationDto;

import com.example.paymentta.dto.TransactionType;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends AbstractController<Transaction, OperationDto, TransactionService>{



    @PostMapping("/account")
    public void addA(@RequestBody OperationDto operationDto) throws ServiceException {

        operationDto.setType(TransactionType.ACCOUNT_NUMBER);
        service.insert(converter.convertDto(operationDto));

    }


    @Override
    @PostMapping("/card")
    public void add(@RequestBody OperationDto operationDto) throws ServiceException {
        operationDto.setType(TransactionType.CARDTOCARD);
        service.insert(converter.convertDto(operationDto));

    }

    @PostMapping("/get")
    public void getTrx(@RequestBody OperationDto trx) {

//        transactionService.getTransactions(trx.getReceiver().getCardNumber(),
//                trx.getSender().getCardNumber(),
//                trx.getDate(),
//                trx.getDate());
    }


}
