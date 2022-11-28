package com.naijagis4me.v1.models;

import com.naijagis4me.v1.enums.AvailabilityForWork;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill extends Base {

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "nameOfSkill", nullable = false)
    private SkillType skillType;

    private Integer yearsOfExperience;

    @Column(length = 1000)
    private String aboutYourAchievements;

    @Enumerated
    private AvailabilityForWork availabilityForWork;

    @ManyToOne
    @JoinColumn(name = "Id")
    private Artisan artisan;

    private double durationTaskTook;
}
