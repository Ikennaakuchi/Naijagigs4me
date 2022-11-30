package com.naijagis4me.v1.models;

import com.naijagis4me.v1.enums.PaymentStatus;
import com.naijagis4me.v1.enums.TransactionStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction extends Base {


    private double totalAmountOfJobDone;
    private String summaryOfWorkDone;
    private String clientName;
    private String artisanName;

    private TransactionStatus transactionStatus;

    private PaymentStatus paymentStatus;

    @OneToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

}
