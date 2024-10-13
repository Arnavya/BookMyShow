package com.sst.bookmyshowsst.repositories;

import com.sst.bookmyshowsst.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    Ticket save(Ticket ticket);
}
