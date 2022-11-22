package com.naijagis4me.v1.models;

import com.naijagis4me.v1.enums.PaymentStatus;
import com.naijagis4me.v1.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private double totalAmountJobDone;

    private String summaryOfWorkDone;

    private TransactionStatus transactionStatus;

    private PaymentStatus paymentStatus;

//    @OneToOne
//    private Customer customer;
//
//    @OneToOne
//    private Artisan artisan;
}
