package main.exception;

/**
 * This exception is thrown if no books were found in the database.
 */
public class BookNotFoundException extends Exception {
    public BookNotFoundException(String s) {
        super(s);
    }
}
