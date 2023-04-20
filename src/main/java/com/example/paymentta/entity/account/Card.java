package com.example.paymentta.entity.account;

import com.example.paymentta.entity.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
public class Card extends AbstractEntity {


    private Long cardNumber;
    private Long CVV2 ;
    private Date expire;






}
