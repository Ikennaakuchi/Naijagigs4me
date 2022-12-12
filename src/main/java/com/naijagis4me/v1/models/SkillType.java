package com.naijagis4me.v1.models;

import com.naijagis4me.v1.enums.NameOfSkills;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillType extends Base {


    @Enumerated
    @Column(nullable = false, unique = true)
    private NameOfSkills nameOfSkill;
}
