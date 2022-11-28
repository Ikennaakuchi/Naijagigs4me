package com.naijagis4me.v1.models;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account_id")
public class AccountDetails extends Base {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "account_id", nullable = false)
//    private Long accountId;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(nullable = false)
    private Long artisanId;

}
