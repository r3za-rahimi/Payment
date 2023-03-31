package com.example.paymentta.dto.convertor;

import com.example.paymentta.dto.TransactionDto;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.entity.account.Account;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.AccountService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = "spring", mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public abstract class TransactionConvertor implements BaseConvertor<TransactionDto, Transaction> {


    @Autowired
    private AccountService accountService;

    @Override
    public abstract Transaction convertDto(TransactionDto transactionDto) throws ServiceException;


    @AfterMapping
    public void setcustomers(@MappingTarget Transaction trx, TransactionDto transactionDto) throws ServiceException {


        switch (transactionDto.getType()) {

            case CARDTOCARD -> {

                Account senderAccount = accountService.getByCardNumber(transactionDto.getSource());
                Account receiverAccount = accountService.getByCardNumber(transactionDto.getDestination());

                trx.setSenderAccount(senderAccount);
                trx.setReceiverAccount(receiverAccount);

            }
            case ACCOUNT_NUMBER -> {

                Account senderAccount = accountService.getByAccountNumber(transactionDto.getSource());
                Account receiverAccount = accountService.getByAccountNumber(transactionDto.getDestination());

                trx.setSenderAccount(senderAccount);
                trx.setReceiverAccount(receiverAccount);

            }
            case SHEBA -> {

            }
            case PAYA -> {

            }
        }
    }

}
