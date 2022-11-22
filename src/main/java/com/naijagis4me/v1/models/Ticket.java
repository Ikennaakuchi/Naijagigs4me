package com.naijagis4me.v1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Ticket implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Column(nullable = false)
    private String status;

    private LocalDateTime completedAt;

    @Column(length = 500)
    private String ticketContent;

    private Long adminId;

//    @Column(nullable = false)
//    @OneToOne(mappedBy = "requestId")
//    private Request request;

}
