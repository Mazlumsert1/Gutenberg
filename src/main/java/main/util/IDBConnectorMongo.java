package main.util;

import com.mongodb.DB;
import com.mongodb.client.MongoDatabase;

public interface IDBConnectorMongo {
    MongoDatabase getConnection();
}
