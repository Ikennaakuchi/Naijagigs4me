package com.naijagis4me.v1.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
abstract class Address extends Base implements Serializable {


    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "home_address", nullable = false)
    private String homeAddress;

}
