package com.naijagis4me.v1.models;

import com.naijagis4me.v1.enums.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Admin extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id", nullable = false)
    private Long adminId;

    @Enumerated
    private Role role;
}
