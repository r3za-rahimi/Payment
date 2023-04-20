package com.example.paymentta.controller;

import com.example.paymentta.dto.OperationDto;

import com.example.paymentta.dto.TransactionDto;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends AbstractController<Transaction, TransactionDto, TransactionService>{


    @GetMapping("/{id}")
    public List<TransactionDto> getTrxAccount(@PathVariable Long id){

        return converter.convertEntity(service.transactionList(id));

    }





}
