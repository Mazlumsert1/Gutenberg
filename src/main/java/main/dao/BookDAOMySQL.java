package main.dao;

import main.dto.Author;
import main.dto.Book;
import main.dto.Location;
import main.util.DBConnectorMySQL;
import main.util.IDBConnectorMySQL;

import java.util.List;

public class BookDAOMySQL implements IBookDAO {

    private IDBConnectorMySQL connector;

    /**
     * Default constructor.
     */
    public BookDAOMySQL() {
        connector = new DBConnectorMySQL();
    }

    /**
     * Constructor with dependency injection.
     * @param connector Connector The connector to the MYSQL database.
     */
    public BookDAOMySQL(IDBConnectorMySQL connector) {
        this.connector = connector;
    }

    /**
     * Returns a List of books from the MYSQL database which have the location of a latitude and longitude mentioned.
     *
     * @param latitude String the latitude of the location.
     * @param longitude String the longitude of the location.
     * @return List of books The list of books where the location is mentioned.
     */
    @Override
    public List<Book> getBooksFromLatLong(String latitude, String longitude) {
        return null;
    }

    /**
     * Returns a List of books from the MYSQL database which is written by the author.
     *
     * @param author Author The author who has written the books.
     * @return List of books which are written by the author.
     */
    @Override
    public List<Book> getBooksAndCitiesFromAuthor(Author author) {
        return null;
    }

    /**
     * Returns a List of books from the MYSQL database where the cities mentioned in a Book is mentioned.
     *
     * @param book Book The book where locations are searched.
     * @return List of books with locations.
     */
    @Override
    public List<Book> getCitiesFromBook(Book book) {
        return null;
    }

    /**
     * Returns a List of books from the MYSQL database which has a location mentioned somewhere in the book.
     *
     * @param location Location The location that is mentioned in the books.
     * @return List of books The books where the location is mentioned.
     */
    @Override
    public List<Book> getAuthorsAndBooksFromCity(Location location) {
        return null;
    }
}
