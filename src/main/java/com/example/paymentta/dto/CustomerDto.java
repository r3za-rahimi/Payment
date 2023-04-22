package com.example.paymentta.dto;


import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
@Builder
public class CustomerDto extends AbstractDto {
    private Long id ;
    @Size(max = 5 , message = "User_Max_Size")
    private String firstName;
    private String lastName;
    private Integer age;

//    private AccountDto account ;
    private Long balance;

}
