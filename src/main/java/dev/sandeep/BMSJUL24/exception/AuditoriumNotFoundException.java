package dev.sandeep.BMSJUL24.exception;

public class AuditoriumNotFoundException extends RuntimeException{
    public AuditoriumNotFoundException() {
    }

    public AuditoriumNotFoundException(String message) {
        super(message);
    }
}
