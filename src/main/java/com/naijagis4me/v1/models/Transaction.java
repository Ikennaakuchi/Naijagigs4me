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
public class Transaction extends Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long transactionId;

    private double totalAmountJobDone;

    private String summaryOfWorkDone;

    private TransactionStatus transactionStatus;

    private PaymentStatus paymentStatus;

    @OneToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @OneToOne
    private Artisan artisan;
}
