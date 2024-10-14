package dev.sandeep.BMSJUL24.repository;

import dev.sandeep.BMSJUL24.model.City;
import dev.sandeep.BMSJUL24.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
