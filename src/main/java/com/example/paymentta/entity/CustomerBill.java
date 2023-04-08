package com.example.paymentta.entity;


import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class CustomerBill extends AbstractEntity{


    private Long payId;

    private Long mobileNumber;

    private String customerName;

    private Long debt;

    private Date dueDate;


}
