package com.example.paymentta.entity.account;

import com.example.paymentta.entity.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Card extends AbstractEntity {


    private Long cardNumber;
    private Long CVV2 ;
    private Date expire;






}
