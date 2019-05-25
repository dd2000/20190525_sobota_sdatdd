package pl.sdacademy.exceptions;

public class DivisionByZeroException extends RuntimeException {

    public DivisionByZeroException(final String message) {
        super(message);
    }
}
