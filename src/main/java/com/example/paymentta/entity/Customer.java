package com.example.paymentta.entity;

import com.example.paymentta.entity.account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
import java.util.Objects;

@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Customer extends AbstractEntity {


    private String firstName;
    private String lastName;
    private Integer age;
    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
//    @JsonIgnore
    private List<Account> accounts;




}
