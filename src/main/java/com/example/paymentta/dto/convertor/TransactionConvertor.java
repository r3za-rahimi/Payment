package com.example.paymentta.dto.convertor;

import com.example.paymentta.dto.OperationDto;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.entity.account.Account;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.AccountService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = "spring", mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public abstract class TransactionConvertor implements BaseConvertor<OperationDto, Transaction> {


    @Autowired
    private AccountService accountService;

    @Override
    public abstract Transaction convertDto(OperationDto operationDto) throws ServiceException;


    @AfterMapping
    public void setcustomers(@MappingTarget Transaction trx, OperationDto operationDto) throws ServiceException {


    }
}
