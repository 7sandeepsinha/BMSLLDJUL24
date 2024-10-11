package dev.sandeep.BMSJUL24.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class City extends BaseModel {
    private String name;
    @OneToMany
    @JoinColumn(name = "city_id")
    private List<Theatre> theatres;
}
