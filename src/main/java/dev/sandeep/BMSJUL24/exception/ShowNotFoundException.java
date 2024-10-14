package dev.sandeep.BMSJUL24.exception;

public class ShowNotFoundException extends RuntimeException{
    public ShowNotFoundException() {
    }

    public ShowNotFoundException(String message) {
        super(message);
    }
}
