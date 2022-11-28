package com.naijagis4me.v1.models;

import com.naijagis4me.v1.enums.NameOfSkills;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillType extends Base {


    @Enumerated
    @Column(nullable = false, unique = true)
    private NameOfSkills nameOfSkill;
}
