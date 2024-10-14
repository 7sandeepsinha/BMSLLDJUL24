package dev.sandeep.BMSJUL24.exception;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException() {
    }

    public MovieNotFoundException(String message) {
        super(message);
    }
}
