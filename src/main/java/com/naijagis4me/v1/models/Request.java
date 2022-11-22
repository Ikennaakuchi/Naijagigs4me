package com.naijagis4me.v1.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Request extends Base implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @OneToOne
    @JoinColumn(name = "skillId")
    private Skill skill;

    @OneToOne
    @JoinColumn(name = "ratingId")
    private Rating rating;

    @ManyToOne
    @JoinColumn(name = "personId", nullable = false)
    private Client client;

}
