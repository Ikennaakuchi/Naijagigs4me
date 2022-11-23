package com.naijagis4me.v1.pojos;

import com.naijagis4me.v1.enums.AvailabilityForWork;
import com.naijagis4me.v1.models.Artisan;
import com.naijagis4me.v1.models.Rating;
import com.naijagis4me.v1.models.SkillType;

import javax.persistence.*;
import java.util.Set;

public class SkillDto {

    private Long skillId;
    private SkillType skillType;

    private String yearsOfExperience;

    private String aboutYourAchievements;

    private AvailabilityForWork availabilityForWork;

    private Set<Rating> ratings;

    private Long artisanId;

    private String durationTaskTook;
}
