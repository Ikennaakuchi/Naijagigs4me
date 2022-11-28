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
@Data
@Entity
public class Artisan extends Person {


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

    @OneToMany(mappedBy = "artisanId", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<AccountDetails> accountDetails;
}
