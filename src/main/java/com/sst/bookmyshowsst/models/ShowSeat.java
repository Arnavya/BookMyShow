package com.sst.bookmyshowsst.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}
/*
  1        :     1
ShowSeat   :   Show
   M       :     1

   1       :     1
ShowSeat   :   seat
   M       :     1
 */