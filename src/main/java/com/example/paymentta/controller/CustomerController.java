package com.example.paymentta.controller;


import com.example.paymentta.dto.CustomerDto;
import com.example.paymentta.entity.Customer;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController extends  AbstractController<Customer , CustomerDto , CustomerService> {


    @Override
    @GetMapping("/{id}")
    public CustomerDto get(@PathVariable Long id) throws ServiceException {
        return super.get(id);
    }
}
