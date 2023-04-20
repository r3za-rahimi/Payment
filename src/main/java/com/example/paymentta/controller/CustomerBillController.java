package com.example.paymentta.controller;


import com.example.paymentta.dto.CustomerBillDto;
import com.example.paymentta.entity.CustomerBill;
import com.example.paymentta.service.CustomerBillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bill")
public class CustomerBillController extends AbstractController<CustomerBill, CustomerBillDto, CustomerBillService> {



    @GetMapping("/{number}")
    public CustomerBillDto getBill(@PathVariable("number") Long number){

       return converter.convertEntity(service.getBill(number));
    }





}
