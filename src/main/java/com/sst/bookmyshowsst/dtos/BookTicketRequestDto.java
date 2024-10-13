package com.sst.bookmyshowsst.dtos;

import com.sst.bookmyshowsst.models.Show;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDto {
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;

}
