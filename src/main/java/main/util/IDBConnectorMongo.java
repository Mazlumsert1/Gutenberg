package main.util;

import com.mongodb.DB;
import com.mongodb.client.MongoDatabase;

/***
 * Interface for the DBConnectorMongo class.
 * 
 * @author Dennis
 */
public interface IDBConnectorMongo {
    MongoDatabase getConnection();
}
