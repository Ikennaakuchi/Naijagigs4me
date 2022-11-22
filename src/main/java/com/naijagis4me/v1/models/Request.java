package com.naijagis4me.v1.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;
}
