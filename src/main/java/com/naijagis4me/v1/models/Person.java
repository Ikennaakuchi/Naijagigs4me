package com.naijagis4me.v1.models;

import com.naijagis4me.v1.enums.Role;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "persons")
public class Person extends Base {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String otherNames;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @UpdateTimestamp
    private LocalDateTime lastLogin;

    private String dob;

    @Enumerated
    private Role role;

    @Column(nullable = false)
    private boolean verificationStatus;

    @OneToMany
    private Set<Address> addresses;

    private boolean verified;
}
