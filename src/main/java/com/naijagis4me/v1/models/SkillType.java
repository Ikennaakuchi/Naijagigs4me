package com.naijagis4me.v1.models;

import com.naijagis4me.v1.enums.NameOfSkills;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SkillType extends Base implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillTypeId;

    @Enumerated
    @Column(nullable = false, unique = true)
    private NameOfSkills nameOfSkill;
}
