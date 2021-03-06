package main.util;

import main.exception.ConnectionAlreadyClosedException;

import java.sql.Connection;
import java.sql.SQLException;

/***
 * Interface for the DBConnectorMySQL class.
 * 
 * @author Dennis
 */
public interface IDBConnectorMySQL {

	Connection getConnection() throws SQLException, ClassNotFoundException;
	void closeConnection() throws ConnectionAlreadyClosedException;

}
