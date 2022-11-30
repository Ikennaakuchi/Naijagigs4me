package com.naijagis4me.v1.models;

import com.naijagis4me.v1.enums.ComplaintType;
import com.naijagis4me.v1.enums.TicketStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket extends Base {


    @Enumerated
    @Column(name = "ticket_status", nullable = false)
    private TicketStatus ticketStatus;

    @Enumerated
    @Column(name = "complaint_type", nullable = false)
    private ComplaintType complaintType;

    private LocalDateTime completedAt;

    @Column(length = 1000)
    private String ticketContent;
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

}
