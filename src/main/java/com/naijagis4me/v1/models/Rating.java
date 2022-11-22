package com.naijagis4me.v1.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Rating extends Base implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @ManyToOne
    @JoinColumn(name = "artisanId", nullable = false)
    private Artisan aritsan;

    @Column(length = 10)
    private int ratingScaleNumber;

    @Column(length = 500)
    private String ratingContent;

    @ManyToOne
    @JoinColumn(name = "skillId", nullable = false)
    private Skill skill;
}
