package dev.sandeep.BMSJUL24.model;

import dev.sandeep.BMSJUL24.model.constant.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    private int price;
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.STRING)
    private ShowSeatStatus seatStatus;

}

/*
    Show : ShowSeat -> 1 : M
    ShowSeat : Seat -> M : 1

    Seat : ShowSeat -> 1 : M
    ShowSeat : Seat -> M : 1

    Show and ShowSeat

    Show
    id time

    ShowSeat
    id seatNumber price



 */
