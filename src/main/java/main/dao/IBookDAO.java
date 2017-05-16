package main.dao;

import main.dto.Author;
import main.dto.Book;
import main.dto.Location;
import main.exception.ConnectionAlreadyClosedException;

import java.util.List;

public interface IBookDAO {
    /**
     * Gets a List of books from a latitude and a longitude.
     *
     * @param latitude String The latitude.
     * @param longitude String The longitude.
     * @return List of books.
     */
    public List<Book> getBooksFromLatLong(double latitude, double longitude, int radius) throws ConnectionAlreadyClosedException;

    /**
     * Returns a List of books an author has written.
     *
     * @param name String The name of the author.
     * @return List of books The books the author has written.
     */
    public List<Book> getBooksAndCitiesFromAuthor(String name) throws ConnectionAlreadyClosedException;

    /**
     * Returns a List of books where cities mentioned in a book is in.
     *
     * @param title String The title of a book.
     * @return List of books The books where the cities are mentioned.
     */
    public List<Location> getCitiesFromBook(String title) throws ConnectionAlreadyClosedException;

    /**
     * Returns a List of books which has a specific location somewhere in the text.
     *
     * @param location Location The location that is mentioned.
     * @return List of books The books where the location is mentioned.
     */
    public List<Book> getAuthorsAndBooksFromCity(Location location);
}
