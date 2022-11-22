package com.naijagis4me.v1.models;

import lombok.*;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Admin extends Person {

    private String Role;
}
