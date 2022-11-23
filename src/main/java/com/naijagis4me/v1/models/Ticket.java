package com.naijagis4me.v1.models;

import com.naijagis4me.v1.enums.ComplaintType;
import com.naijagis4me.v1.enums.TicketStatus;
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
public class Ticket extends Base implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @ManyToOne
    @JoinColumn(name = "adminId")
    private Admin adminAssignedTo;

    @Enumerated
    @Column(name = "ticket_status", nullable = false)
    private TicketStatus ticketStatus;

    @Enumerated
    @Column(name = "complaint_type", nullable = false)
    private ComplaintType complaintType;

    private LocalDateTime completedAt;

    @Column(length = 500)
    private String ticketContent;
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

}
