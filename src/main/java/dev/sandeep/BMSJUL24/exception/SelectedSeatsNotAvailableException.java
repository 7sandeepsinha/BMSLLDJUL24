package dev.sandeep.BMSJUL24.exception;

public class SelectedSeatsNotAvailableException extends RuntimeException{
    public SelectedSeatsNotAvailableException() {
    }

    public SelectedSeatsNotAvailableException(String message) {
        super(message);
    }
}
