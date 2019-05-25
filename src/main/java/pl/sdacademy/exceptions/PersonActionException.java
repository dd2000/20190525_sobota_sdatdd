package pl.sdacademy.exceptions;

public class PersonActionException extends RuntimeException {

    public PersonActionException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

    public PersonActionException(final String msg) {
        super(msg);
    }
}
