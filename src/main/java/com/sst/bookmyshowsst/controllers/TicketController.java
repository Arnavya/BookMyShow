package com.sst.bookmyshowsst.controllers;

import com.sst.bookmyshowsst.dtos.BookTicketRequestDto;
import com.sst.bookmyshowsst.dtos.BookTicketResponseDto;
import com.sst.bookmyshowsst.dtos.ResponseStatus;
import com.sst.bookmyshowsst.models.Ticket;
import com.sst.bookmyshowsst.services.TicketService;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public BookTicketResponseDto bookTicket(BookTicketRequestDto requestDto){
        BookTicketResponseDto responseDto = new BookTicketResponseDto();
        try {
            Ticket ticket = ticketService.bookTicket(requestDto.getUserId(),requestDto.getShowSeatIds());
        }catch(Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
