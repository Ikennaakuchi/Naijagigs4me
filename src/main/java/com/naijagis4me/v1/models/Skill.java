package com.naijagis4me.v1.models;

import com.naijagis4me.v1.enums.AvailabilityForWork;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    private String aboutYourAchievements;

    @Enumerated
    private AvailabilityForWork availabilityForWork;

//    @Transient
//    private Set<Rating> ratings;
    @ManyToOne
    @JoinColumn(name = "artisanId")
    private Artisan artisan;

    private String durationTaskTook;
}
