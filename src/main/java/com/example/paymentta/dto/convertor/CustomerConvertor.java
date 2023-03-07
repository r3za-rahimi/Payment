package com.example.paymentta.dto.convertor;

import com.example.paymentta.dto.CustomerDto;
import com.example.paymentta.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerConvertor implements BaseConvertor<CustomerDto , Customer>{

    @Override
    public Customer convertDto(CustomerDto customerDto) {
        Customer customer = new Customer() ;
        customer.setId(customerDto.getId()) ;
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setBalance(customerDto.getBalance());
        customer.setCardNumber(customerDto.getCardNumber());
        customer.setAge(customerDto.getAge());
        return customer ;
    }

    @Override
    public CustomerDto convertEntity(Customer customer) {
        return null;
    }

}
