package com.example.paymentta;

import com.example.paymentta.controller.AbstractController;
import com.example.paymentta.controller.CustomerController;
import com.example.paymentta.dto.CustomerDto;
import com.example.paymentta.entity.Customer;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.repository.CustomerRepository;
import com.example.paymentta.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;


@SpringBootTest()
@AutoConfigureMockMvc
class PaymentTaApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void contextLoads() {

    }

    @BeforeEach()
    public void setUp() {
        Customer c = customerRepository.save(Customer.builder()
                .firstName("john")
                .lastName("doe")
                .age(30)
                .build());


    }


    @Test
    public void insertCustomer_AndGetSameCustomerWithId() throws Exception{

        Customer c = customerRepository.save(Customer.builder()
                .firstName("john")
                .lastName("doe")
                .age(30)
                .build());

        Customer result = customerRepository.findById(c.getId()).get();

        Assertions.assertThat(result.getId()).isEqualTo(c.getId());
        Assertions.assertThat(result.getFirstName()).isEqualTo(c.getFirstName());


    }

    @Test
    public void DeleteCustomer(){


        Customer result = customerRepository.findById(1L).get();
        customerRepository.delete(result);
        Assertions.assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> customerRepository.findById(1L).get());

    }


    @Test
    public void insertManyCustomer_AndGetAllCustomers() {

        Customer[] customers = {Customer.builder()
                .firstName("john")
                .lastName("doe")
                .age(30)
                .build(), Customer.builder()
                .firstName("john2")
                .lastName("doe")
                .age(30)
                .build()};

        customerRepository.saveAll(Arrays.asList(customers));

        Assertions.assertThat(customerRepository.findAll().size()).isEqualTo(6);

    }

    @Test
    public void updateCustomer() throws Exception{

        Customer c = customerRepository.findById(1L).get();
        c.setFirstName("jonny");
        Customer result = customerService.update(c);


        Assertions.assertThat(result.getFirstName()).isEqualTo("jonny");
    }

    @Test
    public void insertCustomerFromService() throws Exception {

        Customer c = customerService.insert(Customer.builder()
                .firstName("john")
                .lastName("doe")
                .age(30)
                .build());

        Assertions.assertThat(c.getFirstName()).isEqualTo("john");


    }


    @Test
    public void getCustomer_WithController() throws Exception {


        mvc.perform(MockMvcRequestBuilders
                        .get("/customer/{id}",1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("john"))
                .andExpect(jsonPath("$.lastName").value("doe"));
    }

    @Test
    public void InsertCustomer_WithController() throws Exception {


        mvc.perform(MockMvcRequestBuilders
                        .post("/customer")
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString( CustomerDto.builder()
                                .firstName("john")
                                .lastName("doe")
                                .age(30)
                                .build())))
                .andExpect(status().isCreated());

    }

    @Test
    public void ValidateCustomerFirstName_WithController() throws Exception {


        mvc.perform(MockMvcRequestBuilders
                        .post("/customer")
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString( CustomerDto.builder()
                                .firstName("johnsina")
                                .lastName("doe")
                                .age(30)
                                .build())))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.error").value("true"))
                .andExpect(jsonPath("$.message").value("Error in field : firstName User_Max_Size"));

    }


    @Test
    public void testDivideThrowsCorrectException()throws Exception {


        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            divide(100, 0);
        });
    }

    public float divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        return (float) a / b;
    }

}

