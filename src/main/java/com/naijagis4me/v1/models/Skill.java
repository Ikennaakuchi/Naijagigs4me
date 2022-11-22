package com.naijagis4me.v1.models;

import com.naijagis4me.v1.enums.AvailabilityForWork;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Skill extends Base implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "nameOfSkill", nullable = false)
    private SkillType skillType;

    @Column(length = 20)
    private String yearsOfExperience;

    @Column(length = 1000)
    private String aboutYourAchievemnts;

    @Enumerated
    private AvailabilityForWork availabilityForWork;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Rating> ratings;

    private String durationTaskTook;
}
