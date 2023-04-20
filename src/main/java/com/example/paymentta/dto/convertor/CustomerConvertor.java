package com.example.paymentta.dto.convertor;

import com.example.paymentta.dto.CustomerDto;
import com.example.paymentta.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerConvertor extends BaseConvertor<CustomerDto , Customer>{


}
