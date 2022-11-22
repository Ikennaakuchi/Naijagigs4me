package com.naijagis4me.v1.models;


import com.naijagis4me.v1.enums.ArtisanVerificationStatus;
import com.naijagis4me.v1.enums.AvailabilityForWork;
import com.naijagis4me.v1.enums.TaskStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "artisan")
public class Artisan extends Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "artisan_id", nullable = false)
    private Long artisanId;


    @Enumerated
    @Column(name = "verification_status", nullable = false)
    private ArtisanVerificationStatus verificationStatus;

    @Enumerated
    @Column(name = "availability_for_work", nullable = false)
    private AvailabilityForWork available;

    @Enumerated
    @Column(name = "task_status", nullable = false)
    private TaskStatus taskStatus;

    @OneToMany(mappedBy = "artisan",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Skill> skill;

    @OneToMany(mappedBy = "artisan", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<AccountDetails> accountDetails;
}
