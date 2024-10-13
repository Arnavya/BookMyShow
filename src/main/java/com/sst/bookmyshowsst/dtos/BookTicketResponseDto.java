package com.sst.bookmyshowsst.dtos;

import com.sst.bookmyshowsst.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;
}
