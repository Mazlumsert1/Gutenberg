package main.util;

import java.sql.Connection;

public interface IDBConnector {

	Connection getConnection();
	void closeConnection();

}
