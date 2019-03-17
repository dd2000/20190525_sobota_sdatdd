public class ExceptionA extends Exception {
  public ExceptionA(final String msg, final Throwable cause) {
    super(msg, cause);
  }

  public ExceptionA(final String msg) {
    super(msg);
  }
}
