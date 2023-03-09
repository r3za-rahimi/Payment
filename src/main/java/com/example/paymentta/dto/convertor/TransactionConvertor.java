package com.example.paymentta.dto.convertor;

import com.example.paymentta.dto.TransactionDto;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionConvertor implements BaseConvertor<TransactionDto, Transaction>{

    @Autowired
    private CustomerService customerService;
    @Override
    public Transaction convertDto(TransactionDto transactionDto) throws ServiceException {

        switch (transactionDto.getType()){
            case CARDTOCARD -> {return convertDtoCard(transactionDto);}
            case ACCOUNT -> {return convertDtoAccount(transactionDto);}
            default ->  throw new ServiceException("Can not recognized your TransactionType");

        }



    }

    private Transaction convertDtoCard(TransactionDto transactionDto) {
        Transaction trx = new Transaction();
        trx.setAmount(transactionDto.getAmount());
        trx.setDate(new Date());
        trx.setSender(customerService.GetByCardNumber(transactionDto.getSenderCard()));
        trx.setReceiver(customerService.GetByCardNumber(transactionDto.getReceiverCard()));

        return trx;

    }


    private Transaction convertDtoAccount(TransactionDto transactionDto) {
        Transaction trx = new Transaction();
        trx.setAmount(transactionDto.getAmount());
        trx.setDate(new Date());
        trx.setSender(customerService.GetByAccountNumber(transactionDto.getSenderAccount()));
        trx.setReceiver(customerService.GetByAccountNumber(transactionDto.getReceiverAccount()));

        return trx;

    }

    @Override
    public TransactionDto convertEntity(Transaction transaction) {
        TransactionDto trxDto = new TransactionDto();
        trxDto.setAmount(transaction.getAmount());
        trxDto.setSenderCard(transaction.getSender().getCardNumber());
        trxDto.setReceiverCard(transaction.getReceiver().getCardNumber());
        trxDto.setSenderAccount(transaction.getSender().getAccountNumber());
        trxDto.setReceiverAccount(transaction.getReceiver().getAccountNumber());

        return trxDto;
    }
}
