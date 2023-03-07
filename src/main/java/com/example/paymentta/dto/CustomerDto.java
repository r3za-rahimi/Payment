package com.example.paymentta.dto;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CustomerDto {
    private Long id ;
    private String firstName;
    private String lastName;
    private Integer age;
    private String cardNumber;
    private Long balance;

}
