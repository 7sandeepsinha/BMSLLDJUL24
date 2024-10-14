package dev.sandeep.BMSJUL24.service;

import dev.sandeep.BMSJUL24.dto.TicketReqDTO;
import dev.sandeep.BMSJUL24.exception.CityNotFoundException;
import dev.sandeep.BMSJUL24.exception.SelectedSeatsNotAvailableException;
import dev.sandeep.BMSJUL24.exception.TicketNotFoundException;
import dev.sandeep.BMSJUL24.model.City;
import dev.sandeep.BMSJUL24.model.ShowSeat;
import dev.sandeep.BMSJUL24.model.Ticket;
import dev.sandeep.BMSJUL24.model.User;
import dev.sandeep.BMSJUL24.model.constant.ShowSeatStatus;
import dev.sandeep.BMSJUL24.repository.CityRepository;
import dev.sandeep.BMSJUL24.repository.TicketRepository;
import dev.sandeep.BMSJUL24.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ShowSeatService showSeatService;;
    @Autowired
    private ShowService showService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket createTicket(TicketReqDTO ticketDTO) {
        User user = userService.getUserById(ticketDTO.getUserId());
        List<ShowSeat> showSeats = new ArrayList<>();
        for(Integer i : ticketDTO.getShowSeatIds()){
            showSeats.add(showSeatService.getShowSeatById(i));
        }
        //CHECK IF SEATS ARE AVAILABLE
        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SelectedSeatsNotAvailableException("Selected seats not available");
            }
        }
        //LOCK THE SEATS
        for(ShowSeat showSeat : showSeats){
            showSeat.setSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.updateShowSeat(showSeat);
        }
        // NOTE -> Cant merge the above two loops as we need to make sure every seat is available before locking anything

        return generateTicket(user, showSeats);
    }

    private Ticket generateTicket(User user, List<ShowSeat> showSeats) {
        //PAYMENT DONE HERE
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setShowSeats(showSeats);
        ticket.setShow(showSeats.getFirst().getShow());
        ticket = ticketRepository.save(ticket);

        //BOOK THE SEATS
        for(ShowSeat showSeat : showSeats){
            showSeat.setSeatStatus(ShowSeatStatus.BOOKED);
            showSeatService.updateShowSeat(showSeat);
        }
        return ticket;
    }

    public Ticket getTicketById(int id) {
        return ticketRepository.findById(id).orElseThrow(
                () -> new TicketNotFoundException("Ticket with id " + id + " not found")
        );
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public void deleteTicketById(int id) {
        ticketRepository.deleteById(id);
    }
}
/*
    Show -> open layout [ _ _ _ X X ] -> BOOK
    START TRANSACTION;
    Step 1. Checking the availability of the seats
    Step 2. Lock them from being available to other customers
    Step 3. Payment completes, ticket is generated, mark the showSeats as BOOKED
            If payment fails
            mark the showSeats as AVAILABLE
    END TRANSACTION;


    a. Checking in layout
    b. Taking a lock -> SERIALIZABLE TRANSACTION
    c. Checking again


    1
    2
    3
    4
    5

    Book Seat -> 1 2
    [1 2] -> lock -> SERIALIZABLE
    payment completes || 10 mins -> lock would be very resource intensive ?
    unlock

    TRANSACTION 1 -> moves the seat from AVAILABLE TO LOCKED || SERIALIZABLE
    thread lock on rows 1,2 until we change the status of the seats from AVAILABLE -> LOCKED

        ------- resources are free in the period until payment is being done ------
        ------- complete the payment ------

    TRANSACTION 2 -> moves the seat from LOCKED TO BOOKED || DEFAULT -> let JPA decide
 */