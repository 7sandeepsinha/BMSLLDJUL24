package dev.sandeep.BMSJUL24.model;

import dev.sandeep.BMSJUL24.model.constant.AuditoriumFeature;
import dev.sandeep.BMSJUL24.model.constant.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private String language; // make it M:M
    @ElementCollection // maintains relationship between audi and enum calues
    @Enumerated(EnumType.STRING)  // stores the enum constants as table with type string
    private List<MovieFeature> movieFeatures;
}


// code -> movie Object
// name, language, features, show table fetch all shows -> filter by nearby theatres and status