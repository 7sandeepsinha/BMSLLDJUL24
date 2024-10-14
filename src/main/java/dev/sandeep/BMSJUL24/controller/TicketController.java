package dev.sandeep.BMSJUL24.controller;

import dev.sandeep.BMSJUL24.dto.TicketReqDTO;
import dev.sandeep.BMSJUL24.model.Ticket;
import dev.sandeep.BMSJUL24.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    //TODO : convert from ticket model to DTOs with mappers
    @PostMapping("/ticket")
    public ResponseEntity createTicket(@RequestBody TicketReqDTO ticketReqDTO){
         return  ResponseEntity.ok(ticketService.createTicket(ticketReqDTO));
    }
}
