package dev.sandeep.BMSJUL24.exception;

public class ShowSeatNotFoundException extends RuntimeException{
    public ShowSeatNotFoundException() {
    }

    public ShowSeatNotFoundException(String message) {
        super(message);
    }
}
