package dev.sandeep.BMSJUL24.model;

import dev.sandeep.BMSJUL24.model.constant.ShowStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String language;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    @Enumerated(EnumType.STRING)
    private ShowStatus showStatus;
    @OneToMany
    @JoinColumn(name = "show_id")
    private List<ShowSeat> showSeats;
}
/*
    Movie - Show -> 1:M
    Show - Movie -> M:1

    1. Movie -> Shows
    2. Show -> Movie -> required flow

    Audi - Show -> 1:M

    Show - ShowSeat -> 1:M



    Movie - Show -> 1 : M
    Show - Movie -> M : 1

    class Movie{
    @OneToMany
    List<Show>
    }

    class Show{
    @ManyToOne
    Movie movie;
    }

 */