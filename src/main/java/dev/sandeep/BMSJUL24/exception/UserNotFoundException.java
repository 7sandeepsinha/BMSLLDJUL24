package dev.sandeep.BMSJUL24.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
