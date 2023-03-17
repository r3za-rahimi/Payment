package com.example.paymentta.dto.convertor;

import com.example.paymentta.dto.TransactionDto;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.CustomerService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Mapper(componentModel = "spring")
public abstract class TransactionConvertor implements BaseConvertor<TransactionDto, Transaction>{


    @Autowired
     private CustomerService customerService;


    @Override
    public abstract Transaction convertDto(TransactionDto transactionDto) throws ServiceException ;


    @AfterMapping
    public void setcustomers(TransactionDto transactionDto , @MappingTarget Transaction trx) throws ServiceException {

        switch (transactionDto.getType()){

            case CARDTOCARD -> {
                trx.setSender(customerService.GetByCardNumber(transactionDto.getSource()));
                trx.setReceiver(customerService.GetByCardNumber(transactionDto.getDestination()));
            }
            case ACCOUNT -> {
                trx.setSender(customerService.GetByAccountNumber(transactionDto.getSource()));
                trx.setReceiver(customerService.GetByAccountNumber(transactionDto.getDestination()));
            }
        }
    }
}
