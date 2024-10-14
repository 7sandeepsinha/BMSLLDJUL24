package dev.sandeep.BMSJUL24.service;

import dev.sandeep.BMSJUL24.exception.CityNotFoundException;
import dev.sandeep.BMSJUL24.exception.TheatreNotFoundException;
import dev.sandeep.BMSJUL24.model.City;
import dev.sandeep.BMSJUL24.model.Theatre;
import dev.sandeep.BMSJUL24.repository.CityRepository;
import dev.sandeep.BMSJUL24.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public Theatre getTheatreById(int id) {
        return theatreRepository.findById(id).orElseThrow(
                () -> new TheatreNotFoundException("Theatre with id " + id + " not found")
        );
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public void deleteTheatreById(int id) {
        theatreRepository.deleteById(id);
    }
}