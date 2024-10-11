package dev.sandeep.BMSJUL24.model;

import dev.sandeep.BMSJUL24.model.constant.AuditoriumFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String name;
    private int capacity;
    @OneToMany
    @JoinColumn(name = "auditorium_id")
    private List<Seat> seats;
    @OneToMany
    @JoinColumn(name = "auditorium_id")
    private List<Show> shows;
    // these annotations will help to setup 1:M or M:M relationships between entity and enum
    @ElementCollection // maintains relationship between audi and enum calues
    @Enumerated(EnumType.STRING)  // stores the enum constants as table with type string
    private List<AuditoriumFeature> auditoriumFeatures;
}
/*
  1. Table for enum features
  2. mapping between audiId and featureId

  1 Audi -> M Shows
  1 show -> 1 audi
 */