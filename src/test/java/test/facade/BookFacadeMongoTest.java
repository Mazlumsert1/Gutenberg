package test.facade;

import main.dao.BookDAOMongo;
import main.dao.BookDAOMySQL;
import main.dao.IBookDAO;
import main.dto.Author;
import main.dto.Book;
import main.dto.Location;
import main.exception.BookNotFoundException;
import main.facade.BookFacadeMongo;
import main.facade.IBookFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookFacadeMongoTest {

    @Test
    public void defaultConstructorTest() {
        IBookFacade facade = new BookFacadeMongo();
        assertThat(facade, is(notNullValue()));
    }

    @Test
    public void dependencyInjectedConstructorTest() {
        IBookDAO dao = new BookDAOMongo();
        IBookFacade facade = new BookFacadeMongo(dao);
        assertThat(facade, is(notNullValue()));
    }

    @Test
    public void getSuccessfulBooksFromLatitudeLongitudeTest() throws BookNotFoundException {
        IBookFacade facade;
        IBookDAO dao;

        List<Book> books = new ArrayList<>();
        books.add(new Book());

        dao = mock(IBookDAO.class);
        when(dao.getBooksFromLatLong(anyString(), anyString())).
                thenReturn(books);

        facade = new BookFacadeMongo(dao);
        assertThat(facade.getBooksFromLatLong(anyString(), anyString()), is(books));
    }

    @Test(expected = BookNotFoundException.class)
    public void getEmptyResponseBooksFromLatitudeLongitudeTest() throws BookNotFoundException {
        IBookFacade facade;
        IBookDAO dao;

        dao = mock(IBookDAO.class);
        when(dao.getBooksFromLatLong(anyString(),anyString())).
                thenReturn(null);

        facade = new BookFacadeMongo(dao);
        facade.getBooksFromLatLong(anyString(), anyString());
    }

    @Test
    public void getSuccessfulBooksAndCitiesFromAuthorTest() throws BookNotFoundException {
        IBookFacade facade;
        IBookDAO dao;

        List<Location> locations = new ArrayList<>();
        locations.add(new Location(1.1231, 1.12312, "Jydeland"));
        List<Author> authors = new ArrayList<>();

        List<Book> books = new ArrayList<>();
        books.add(new Book("title", authors, locations, "text"));

        Author author = new Author();
        dao = mock(BookDAOMongo.class);
        when(dao.getBooksAndCitiesFromAuthor(author)).
                thenReturn(books);

        facade = new BookFacadeMongo(dao);
        assertThat(facade.getBooksAndCitiesFromAuthor(author), is(books));
    }

    @Test(expected = BookNotFoundException.class)
    public void getEmptyResponseBooksAndCitiesFromAuthorTest() throws BookNotFoundException {
        IBookFacade facade;
        IBookDAO dao;

        Author author = new Author();
        dao = mock(BookDAOMongo.class);
        when(dao.getBooksAndCitiesFromAuthor(author)).
                thenReturn(null);

        facade = new BookFacadeMongo(dao);
        facade.getBooksAndCitiesFromAuthor(author);
    }

    @Test
    public void getSuccessfulCitiesFromBookTest() throws  BookNotFoundException {
        IBookFacade facade;
        IBookDAO dao;

        List<Location> locations = new ArrayList<>();
        locations.add(new Location(1.1231, 1.12312, "Jydeland"));
        List<Author> authors = new ArrayList<>();

        List<Book> books = new ArrayList<>();
        books.add(new Book("title", authors, locations, "text"));

        Book book = new Book();
        dao = mock(BookDAOMySQL.class);
        when(dao.getCitiesFromBook(book))
                .thenReturn(books);

        facade = new BookFacadeMongo(dao);
        assertThat(facade.getCitiesFromBook(book), is(books));
    }

    @Test(expected = BookNotFoundException.class)
    public void getEmptyResponseCitiesFromBookTest() throws BookNotFoundException {
        IBookFacade facade;
        IBookDAO dao;

        Book book = new Book();
        dao = mock(BookDAOMySQL.class);
        when(dao.getCitiesFromBook(book)).
                thenReturn(null);

        facade = new BookFacadeMongo(dao);
        facade.getCitiesFromBook(book);
    }

    @Test
    public void getSuccessfulAuthorsAndBooksFromCity() throws BookNotFoundException {
        IBookFacade facade;
        IBookDAO dao;

        List<Location> locations = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("Hans"));

        List<Book> books = new ArrayList<>();
        books.add(new Book("title", authors, locations, "text"));

        Location location = new Location();
        dao = mock(BookDAOMySQL.class);
        when(dao.getAuthorsAndBooksFromCity(location)).
                thenReturn(books);

        facade = new BookFacadeMongo(dao);
        assertThat(facade.getAuthorsAndBookFromCity(location), is(books));
    }

    @Test(expected = BookNotFoundException.class)
    public void getEmptyResponseAuthorsAndBooksFromCity() throws BookNotFoundException {
        IBookFacade facade;
        IBookDAO dao;

        Location location = new Location();
        dao = mock(BookDAOMySQL.class);
        when(dao.getAuthorsAndBooksFromCity(location)).
                thenReturn(null);

        facade = new BookFacadeMongo(dao);
        facade.getAuthorsAndBookFromCity(location);
    }
}
