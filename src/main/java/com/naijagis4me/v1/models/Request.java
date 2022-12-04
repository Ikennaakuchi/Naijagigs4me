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
    @JoinColumn(name = "Id", insertable = false, updatable = false)
    private Skill skill;

    @OneToOne
    @JoinColumn(name = "Id", insertable = false, updatable = false)
    private Rating rating;

    @ManyToOne
    @JoinColumn(name = "Id", insertable = false, updatable = false)
    private Client client;

}
