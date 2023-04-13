package com.example.paymentta.controller.aspects;

import com.example.paymentta.dto.OperationDto;
import com.example.paymentta.dto.TransactionType;
import com.example.paymentta.dto.convertor.BaseConvertor;
import com.example.paymentta.entity.Operation;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operation")
public class OperationController {


    @Autowired
    private OperationService service;

    @Autowired
    BaseConvertor<OperationDto, Operation> converter;

    @PostMapping("/card")
    public void addA(@RequestBody OperationDto operationDto) throws ServiceException {

        operationDto.setType(TransactionType.CARDTOCARD);
        service.doTransaction(converter.convertDto(operationDto));

    }


}
