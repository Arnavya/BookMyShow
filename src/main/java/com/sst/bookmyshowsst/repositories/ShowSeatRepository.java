package com.sst.bookmyshowsst.repositories;

import com.sst.bookmyshowsst.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findAllById(Iterable<Long> ids);

}
