package dev.sandeep.BMSJUL24.service;

import dev.sandeep.BMSJUL24.exception.SeatNotFoundException;
import dev.sandeep.BMSJUL24.model.Seat;
import dev.sandeep.BMSJUL24.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat getSeatById(int id) {
        return seatRepository.findById(id).orElseThrow(
                () -> new SeatNotFoundException("Seat with id " + id + " not found")
        );
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public void deleteSeatById(int id) {
        seatRepository.deleteById(id);
    }
}