package com.example.paymentta.dto.convertor;

import com.example.paymentta.dto.OperationDto;
import com.example.paymentta.entity.Operation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperationConverter extends BaseConvertor<OperationDto , Operation> {
}
