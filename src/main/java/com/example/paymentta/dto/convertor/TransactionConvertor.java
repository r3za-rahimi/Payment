package com.example.paymentta.dto.convertor;

import com.example.paymentta.dto.OperationDto;
import com.example.paymentta.dto.TransactionDto;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.entity.account.Account;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.AccountService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = "spring")
public interface TransactionConvertor extends BaseConvertor<TransactionDto, Transaction> {




}
