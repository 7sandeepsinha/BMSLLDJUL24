package dev.sandeep.BMSJUL24.repository;

import dev.sandeep.BMSJUL24.model.City;
import dev.sandeep.BMSJUL24.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
}
