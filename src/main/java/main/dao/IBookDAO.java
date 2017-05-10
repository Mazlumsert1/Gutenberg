package main.dao;

import main.dto.Author;
import main.dto.Book;
import main.dto.Location;

import java.util.List;

public interface IBookDAO {
    /**
     * Gets a List of books from a latitude and a longitude.
     *
     * @param latitude String The latitude.
     * @param longitude String The longitude.
     * @return List of books.
     */
    public List<Book> getBooksFromLatLong(String latitude, String longitude);

    /**
     * Returns a List of books an author has written.
     *
     * @param author Author The author.
     * @return List of books The books the author has written.
     */
    public List<Book> getBooksAndCitiesFromAuthor(Author author);

    /**
     * Returns a List of books where cities mentioned in a book is in.
     *
     * @param book Book The book.
     * @return List of books The books where the cities are mentioned.
     */
    public List<Book> getCitiesFromBook(Book book);

    /**
     * Returns a List of books which has a specific location somewhere in the text.
     *
     * @param location Location The location that is mentioned.
     * @return List of books The books where the location is mentioned.
     */
    public List<Book> getAuthorsAndBooksFromCity(Location location);
}
