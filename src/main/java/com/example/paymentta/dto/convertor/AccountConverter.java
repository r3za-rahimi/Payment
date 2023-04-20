package com.example.paymentta.dto.convertor;

import com.example.paymentta.dto.AccountDto;
import com.example.paymentta.entity.account.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountConverter  extends BaseConvertor<AccountDto , Account>{
}
