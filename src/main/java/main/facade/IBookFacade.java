package main.facade;

import main.dto.Author;
import main.dto.Book;
import main.dto.Location;
import main.exception.BookNotFoundException;

import java.util.List;

public interface IBookFacade {
    public List<Book> getBooksFromLatLong(String latitude, String longitude) throws BookNotFoundException;
    public List<Book> getBooksAndCitiesFromAuthor(Author author) throws BookNotFoundException;
    public List<Book> getCitiesFromBook(Book book) throws BookNotFoundException;
    public List<Book> getAuthorsAndBookFromCity(Location location) throws BookNotFoundException;
}
