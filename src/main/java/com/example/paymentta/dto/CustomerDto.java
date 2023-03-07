package com.example.paymentta.dto;


import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CustomerDto {
    private Long id ;
    private String firstName;
    private String lastName;

    private Integer age;
    @Pattern(regexp = "\\d{8}" , message = "check your Card")
    private String cardNumber;
    private Long balance;

}
