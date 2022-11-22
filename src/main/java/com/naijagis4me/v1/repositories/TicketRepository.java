package com.naijagis4me.v1.repositories;

import com.naijagis4me.v1.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
