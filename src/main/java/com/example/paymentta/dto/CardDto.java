package com.example.paymentta.dto;

import com.example.paymentta.entity.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto extends AbstractDto {


    private Long cardNumber;
    private Long CVV2;
    private Date expire;


}
