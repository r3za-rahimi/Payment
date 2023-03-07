package com.example.paymentta.dto.convertor;

import com.example.paymentta.dto.TransactionDto;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionConvertor implements BaseConvertor<TransactionDto , Transaction>{

    @Autowired
    private CustomerService customerService;
    @Override
    public Transaction convertDto(TransactionDto transactionDto) {
        Transaction trx = new Transaction();
        trx.setAmount(transactionDto.getAmount());
        trx.setDate(new Date());
        trx.setSender(customerService.GetByCardNumber(transactionDto.getSender()));
        trx.setReceiver(customerService.GetByCardNumber(transactionDto.getReceiver()));

        return trx;

    }

    @Override
    public TransactionDto convertEntity(Transaction transaction) {
        TransactionDto trxDto = new TransactionDto();
        trxDto.setAmount(transaction.getAmount());
        trxDto.setSender(transaction.getSender().getCardNumber());
        trxDto.setReceiver(transaction.getReceiver().getCardNumber());

        return trxDto;
    }
}
