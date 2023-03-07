package com.example.paymentta.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Transaction extends AbstractEntity{


    private Date date;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Customer sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Customer receiver;
    private Long amount;
}
