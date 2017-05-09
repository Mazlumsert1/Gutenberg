package main.util;

import main.exception.ConnectionAlreadyClosedException;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDBConnectorMySQL {

	Connection getConnection() throws SQLException, ClassNotFoundException;
	void closeConnection() throws ConnectionAlreadyClosedException;

}
