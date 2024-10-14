package dev.sandeep.BMSJUL24.exception;

public class TicketNotFoundException extends RuntimeException{
    public TicketNotFoundException() {
    }

    public TicketNotFoundException(String message) {
        super(message);
    }
}
