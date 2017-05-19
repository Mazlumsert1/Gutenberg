package test.dao;

import main.dao.BookDAOMySQL;
import main.dto.Book;
import main.dto.Location;
import main.exception.BookNotFoundException;
import main.exception.ConnectionAlreadyClosedException;
import main.util.DBConnectorMongo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BookDAOMySQLIT {

    BookDAOMySQL dao;

    @Test
    public void defaultConstructorTest() {
        dao = new BookDAOMySQL();

        assertThat(dao, is(notNullValue()));
    }

    @Test
    public void dependencyConstructorTest() {
        dao = new BookDAOMySQL();

        assertThat(dao, is(notNullValue()));
    }

    @Test
    public void successfulGetCitiesFromBookTest() throws ConnectionAlreadyClosedException {
        dao = new BookDAOMySQL();

        List<Location> cities = dao.getCitiesFromBook("Ivanhoe");

        assertThat(cities, hasSize(greaterThan(0)));

    }

    @Test
    public void unsuccessfulGetCitiesFromBookTest() throws ConnectionAlreadyClosedException {
        dao = new BookDAOMySQL();

        List<Location> cities = dao.getCitiesFromBook("BoogerButt Anthology, Book III");

        assertThat(cities, hasSize(equalTo(0)));

    }

    @Test
    public void successfulGetAuthorsAndBooksFromCity() throws ConnectionAlreadyClosedException {
        dao = new BookDAOMySQL();

        List<Book> books = dao.getAuthorsAndBooksFromCity("Washington");

        assertThat(books, hasSize(greaterThan(0)));
    }

    @Test
    public void unsuccessfulGetAuthorsAndBooksFromCity() throws ConnectionAlreadyClosedException {
        dao = new BookDAOMySQL();

        List<Book> books = dao.getAuthorsAndBooksFromCity("New Donk City");

        assertThat(books, hasSize(equalTo(0)));
    }

    @Test
    public void successfulGetBooksAndCitiesFromAuthor() throws BookNotFoundException, ConnectionAlreadyClosedException {
        dao = new BookDAOMySQL();

        List<Book> books = dao.getBooksAndCitiesFromAuthor("Edith Wharton");

        assertThat(books, hasSize(greaterThan(0)));
    }

    @Test
    public void unsuccessfulGetBooksAndCitiesFromAuthor() throws BookNotFoundException, ConnectionAlreadyClosedException {
        dao = new BookDAOMySQL();

        List<Book> books = dao.getBooksAndCitiesFromAuthor("Slab PlunkChunk");

        assertThat(books, hasSize(equalTo(0)));
    }

    @Test
    public void successfulGetBooksFromLatLong() throws ConnectionAlreadyClosedException {
        dao = new BookDAOMySQL();

        List<Book> books = dao.getBooksFromLatLong(52.18935,-2.22001,50);

        assertThat(books, hasSize(greaterThan(0)));
    }

    @Test
    public void unsuccessfulGetBooksFromLatLong() throws ConnectionAlreadyClosedException {
        dao = new BookDAOMySQL();

        List<Book> books = dao.getBooksFromLatLong(420420.0,-696969.0,666);

        assertThat(books, hasSize(equalTo(0)));
    }

}
