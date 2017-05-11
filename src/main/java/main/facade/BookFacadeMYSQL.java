package main.facade;

import main.dao.BookDAOMYSQL;
import main.dao.IBookDAO;
import main.dto.Author;
import main.dto.Book;
import main.dto.Location;
import main.exception.BookNotFoundException;

import java.util.List;

public class BookFacadeMYSQL implements IBookFacade{

    private IBookDAO dao;

    /**
     * Default constructor.
     */
    public BookFacadeMYSQL() {
        this.dao = new BookDAOMYSQL();
    }

    /**
     * Constructor with dependency injector.
     * @param dao IBookDAO The dao.
     */
    public BookFacadeMYSQL(IBookDAO dao) {
        this.dao = dao;
    }

    /**
     * Gets a list of books from the data access object and returns it.
     *
     * @param latitude String The latitude of the location.
     * @param longitude String The longitude of the location.
     * @return List of Books The books that mentions the location.
     * @throws BookNotFoundException Exception If no books mention the location.
     */
    @Override
    public List<Book> getBooksFromLatLong(String latitude, String longitude) throws BookNotFoundException {
        List<Book> books = dao.getBooksFromLatLong(latitude, longitude);
        if (null == books) {
            throw new BookNotFoundException("No Book was found");
        }
        return books;
    }

    /**
     * Gets a list of books from the dao and returns it.
     *
     * @param author Author The author that is searched for in the database.
     * @return List of Books The books that the Author has written.
     * @throws BookNotFoundException Exception If the author has not written any books.
     */
    @Override
    public List<Book> getBooksAndCitiesFromAuthor(Author author) throws BookNotFoundException {
        List<Book> books = dao.getBooksAndCitiesFromAuthor(author);
        if (null == books) {
            throw new BookNotFoundException("No Book was found");
        }
        return books;
    }

    /**
     * Gets a list of books from the dao and returns it.
     *
     * @param book Book The book that is searched for in the database.
     * @return List of Books The books which mentions cities mentioned in the book.
     * @throws BookNotFoundException Exception If the book doesn't mention any cities.
     */
    @Override
    public List<Book> getCitiesFromBook(Book book) throws BookNotFoundException {
        List<Book> books = dao.getCitiesFromBook(book);
        if (null == books) {
            throw new BookNotFoundException("No Book was found");
        }
        return books;
    }

    /**
     * Gets a list of books from the dao and returns it.
     *
     * @param location The location that is searched for in the database.
     * @return List of Books The books which the location is mentioned in.
     * @throws BookNotFoundException Exception If there is no books that is mentioned on the location.
     */
    @Override
    public List<Book> getAuthorsAndBookFromCity(Location location) throws BookNotFoundException {
        List<Book> books = dao.getAuthorsAndBooksFromCity(location);
        if (null == books) {
            throw new BookNotFoundException("No Book was found");
        }
        return books;
    }
}
