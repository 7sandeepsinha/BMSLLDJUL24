package dev.sandeep.BMSJUL24.repository;

import dev.sandeep.BMSJUL24.model.Show;
import dev.sandeep.BMSJUL24.model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
}
