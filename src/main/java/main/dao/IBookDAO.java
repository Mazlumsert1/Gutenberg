package main.dao;

import main.dto.Author;
import main.dto.Book;
import main.dto.Location;

import java.util.List;

public interface IBookDAO {
    public List<Book> getBooksFromLatLong(String latitude, String longitude);
    public List<Book> getBooksAndCitiesFromAuthor(Author author);
    public List<Book> getCitiesFromBook(Book book);
    public List<Book> getAuthorsAndBooksFromCity(Location location);
}
