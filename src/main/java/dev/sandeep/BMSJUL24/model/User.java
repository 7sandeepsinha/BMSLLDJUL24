package dev.sandeep.BMSJUL24.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "BMS_USER")
public class User extends BaseModel {
    private String name;
    private String email;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Ticket> tickets;
}

/*
    User : Ticket ->  1:M

    1 Ticket -> M ShowSeats
    1 ShowSeat -> 1 Ticket

    Ticket:ShowSeat -> 1:M
    ShowSeat table will have ticketId
 */