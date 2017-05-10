package main.dao;

import main.dto.Author;
import main.dto.Book;
import main.dto.Location;
import main.util.IDBConnector;

import java.util.List;

public class BookDAOMYSQL implements IBookDAO {

    private IDBConnector connector;

    public BookDAOMYSQL() {
    }

    public BookDAOMYSQL(IDBConnector connector) {
        this.connector = connector;
    }

    @Override
    public List<Book> getBooksFromLatLong(String latitude, String longitude) {
        return null;
    }

    @Override
    public List<Book> getBooksAndCitiesFromAuthor(Author author) {
        return null;
    }

    @Override
    public List<Book> getCitiesFromBook(Book book) {
        return null;
    }

    @Override
    public List<Book> getAuthorsAndBooksFromCity(Location location) {
        return null;
    }
}
