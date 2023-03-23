package com.example.paymentta.dto.convertor;

import com.example.paymentta.dto.TransactionDto;
import com.example.paymentta.entity.Customer;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.entity.account.Account;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.AccountService;
import com.example.paymentta.service.CustomerService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Mapper(componentModel = "spring", mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public abstract class TransactionConvertor implements BaseConvertor<TransactionDto, Transaction> {


    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;


    @Override
    public abstract Transaction convertDto(TransactionDto transactionDto) throws ServiceException;



    @AfterMapping
public void setcustomers( @MappingTarget Transaction trx, TransactionDto transactionDto) throws ServiceException {


        switch (transactionDto.getType()) {

            case CARDTOCARD -> {

                Account senderAccount = accountService.getByAccount(transactionDto.getSource());
                Account receiverAccount = accountService.getByAccount(transactionDto.getDestination());

                trx.setSenderAccount(senderAccount);
                trx.setReceiverAccount(receiverAccount);
                trx.setSender(customerService.getByAccount(senderAccount));
                trx.setReceiver(customerService.getByAccount(receiverAccount));
            }
            case ACCOUNT -> {

//                Account senderAccount = accountService.getByCardNumber(transactionDto.getSource());
//                Account receiverAccount = accountService.getByCardNumber(transactionDto.getDestination());
//
//                trx.setSenderAccount(senderAccount);
//                trx.setReceiverAccount(receiverAccount);
//                trx.setSender(customerService.getByAccount(senderAccount));
//                trx.setReceiver(customerService.getByAccount(receiverAccount));
            }
        }
    }

}
