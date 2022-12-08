package com.naijagis4me.v1.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Client extends Base{
    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Request> requests;

    @OneToMany(mappedBy = "client")
    private Set<Ticket> tickets;

    @OneToOne
    @JoinColumn(name = "transactionId")
    private Transaction transaction;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Person person;


}
