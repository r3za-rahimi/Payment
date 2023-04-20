package com.example.paymentta.dto;


import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class CustomerDto extends AbstractDto {
    private Long id ;
    private String firstName;
    private String lastName;
    private Integer age;

//    private AccountDto account ;
    private Long balance;

}
