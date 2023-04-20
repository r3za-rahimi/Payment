package com.example.paymentta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBillDto extends AbstractDto {

    private Long Id;

    private Long payId;

    private Long mobileNumber;

    private String customerName;

    private Long debt;

    private Date dueDate;


}
