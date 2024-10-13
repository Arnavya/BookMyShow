package com.sst.bookmyshowsst.services;

import com.sst.bookmyshowsst.models.*;
import com.sst.bookmyshowsst.repositories.ShowSeatRepository;
import com.sst.bookmyshowsst.repositories.TicketRepository;
import com.sst.bookmyshowsst.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService{
    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private TicketRepository ticketRepository;

    public TicketServiceImpl(UserRepository userRepository,ShowSeatRepository showSeatRepository,TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)//All the queries which are execute within bookTicket method is going to be executed within a lock
    public Ticket bookTicket(Long userId, List<Long> showSeatIds) {
        /*
        Steps if user is trying to book a ticket
        1)Get the users from the DB using given userId.
        2)Get the show Seat details from DB.
        3)Check if all the seats selected by the users available or not.
        4)If even a single seat is not available, then booking can't be done.
        5)If all the seats are available,proceed with the booking.
         */
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) {
            //Redirect the user to Login or SignUp page.
            throw new RuntimeException("User with userId "+ userId + " doesn't exist");
        }
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for(ShowSeat showSeat : showSeats) {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){//if the status is not available for any seat.
                throw new RuntimeException("Show seat not available please try booking some other seat");
            }
        }
        //Call payment service to complete the payment.
        //How to create booking
        //-> get the seats --> change the status --> save in the database.
        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);//change the status of the show seat object as booked
            showSeatRepository.save(showSeat);//saving the status of the showseat in the DB.
        }
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(String.valueOf(UUID.randomUUID()));
        ticket.setTicketStatus(TicketStatus.CONFIRMED);
        ticket.setUser(optionalUser.get());
        ticket.setTimestamp(new Date());
        ticket.setPayment(new Payment());
        ticket.setAmount(1000);
        return ticketRepository.save(ticket);
    }
}
