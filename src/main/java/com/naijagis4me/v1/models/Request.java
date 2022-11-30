package com.naijagis4me.v1.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request extends Base {

    @OneToOne
    @JoinColumn(name = "Id")
    private Skill skill;

    @OneToOne
    @JoinColumn(name = "Id")
    private Rating rating;

    @ManyToOne
    @JoinColumn(name = "Id", nullable = false)
    private Client client;

}
