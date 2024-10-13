package com.sst.bookmyshowsst.services;

import com.sst.bookmyshowsst.models.Ticket;

import java.util.List;

public interface TicketService {
    Ticket bookTicket(Long userId, List<Long> showSeatIds);
}
