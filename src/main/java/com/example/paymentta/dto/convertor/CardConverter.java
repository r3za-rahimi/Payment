package com.example.paymentta.dto.convertor;

import com.example.paymentta.dto.CardDto;
import com.example.paymentta.entity.account.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardConverter extends BaseConvertor<CardDto , Card>{


}
