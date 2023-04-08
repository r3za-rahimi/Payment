package com.example.paymentta.dto.convertor;

import com.example.paymentta.dto.CustomerBillDto;
import com.example.paymentta.entity.CustomerBill;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CustomerBillConverter extends BaseConvertor<CustomerBillDto, CustomerBill>{



}
