package main.dao;

import main.dto.Author;
import main.dto.Book;
import main.dto.Location;
import main.util.DBConnectorMongo;

import java.util.List;

/**
 * Created by Ebbe Nielsen on 12/05/2017.
 */
public class BookDAOMongo implements IBookDAO {

    DBConnectorMongo connector;

    /**
     * Default Constructor.
     */
    public BookDAOMongo() {
        connector = new DBConnectorMongo();
    }

    /**
     * Constructor with dependency injection.
     *
     * @param connector DBConnectorMongo The connector to the Mongo database.
     */
    public BookDAOMongo(DBConnectorMongo connector) {
        this.connector = connector;
    }

    /**
     * Returns a List of books from the Mongo database which have the location of a latitude and longitude mentioned.
     *
     * @param latitude String The latitude of the location.
     * @param longitude String The longitude of the location.
     * @return List of books The list of books where the location is mentioned.
     */
    @Override
    public List<Book> getBooksFromLatLong(String latitude, String longitude, int radius) {
        return null;
    }

    /**
     * Returns a List of books from the Mongo database which is written by the author.
     *
     * @param name String The name of the author who has written the books.
     * @return List of books The books which are written by the author.
     */
    @Override
    public List<Book> getBooksAndCitiesFromAuthor(String name) {
        return null;
    }

    /**
     * Returns a List of books from the Mongo database where the cities mentioned in a Book is mentioned.
     *
     * @param book Book The book where locations are searched.
     * @return List of books with locations.
     */
    @Override
    public List<Location> getCitiesFromBook(String title) {
        return null;
    }

    /**
     * Returns a List of books from the Mongo database which has a location mentioned somewhere in the book.
     *
     * @param location Location The location that is mentioned in the books.
     * @return List of books The books where the location is mentioned.
     */
    @Override
    public List<Book> getAuthorsAndBooksFromCity(Location location) {
        return null;
    }
}
