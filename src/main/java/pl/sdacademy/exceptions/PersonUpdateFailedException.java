package pl.sdacademy.exceptions;

public class PersonUpdateFailedException extends RuntimeException {

    public PersonUpdateFailedException(final String message) {
        super(message);
    }
}
