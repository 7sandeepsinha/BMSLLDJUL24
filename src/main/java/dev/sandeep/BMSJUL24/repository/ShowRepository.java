package dev.sandeep.BMSJUL24.repository;

import dev.sandeep.BMSJUL24.model.City;
import dev.sandeep.BMSJUL24.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
}
