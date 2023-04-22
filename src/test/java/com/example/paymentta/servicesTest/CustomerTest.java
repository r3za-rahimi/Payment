package com.example.paymentta.servicesTest;

import com.example.paymentta.entity.Customer;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.repository.CustomerRepository;
import com.example.paymentta.service.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;


//@ComponentScan(basePackages = "com.example")
//@TestComponent
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class CustomerTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    private Customer customer;


    @BeforeEach
    public void setup() throws InstantiationException, IllegalAccessException, ServiceException {

        customer = Customer.builder()
                .firstName("john")
                .lastName("doe")
                .age(30)
                .build();


        when(customerService.insert(Customer.class.newInstance())).thenReturn(customer);
        when(customerService.update(Customer.class.newInstance())).thenReturn(Customer.builder().age(50).build());

    }

    @Test
    public void insertCustomer() throws Exception{

        Customer insCustomer = this.customerRepository.save(customer);

        Assertions.assertThat(insCustomer).isEqualTo(customer);

    }

    @Test
    public void updateCustomer() throws Exception{

      Customer c =  Customer.builder()
                .firstName("reza")
                .lastName("rahimi")
                .age(29).build();

        Assertions.assertThat(customerService.update(c).getAge()).isEqualTo(50);

    }


}




