package pl.sdacademy.exceptions;

public class DatabaseConnectionException extends RuntimeException {

    public DatabaseConnectionException(final String message) {
        super(message);
    }
}
