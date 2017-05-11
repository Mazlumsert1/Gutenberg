package main.exception;

/**
 * Thrown if a closed or non-existed database connection is attempted to be closed.
 */
public class ConnectionAlreadyClosedException extends Exception {

	public ConnectionAlreadyClosedException(String s) {
		super(s);
	}
}
