package dev.sandeep.BMSJUL24.model;

import dev.sandeep.BMSJUL24.model.constant.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    @OneToMany
    @JoinColumn(name = "ticket_id")
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Show show;
    private LocalDateTime bookingTime;
    private double totalCost;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

}

// Show : Ticket -> 1 : M
// Ticket : Show -> M : 1

