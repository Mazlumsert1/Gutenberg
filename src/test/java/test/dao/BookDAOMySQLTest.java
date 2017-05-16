package test.dao;

import main.dao.BookDAOMySQL;
import main.dto.Author;
import main.dto.Book;
import main.dto.Location;
import main.exception.BookNotFoundException;
import main.exception.ConnectionAlreadyClosedException;
import main.util.DBConnectorMySQL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookDAOMySQLTest {

	BookDAOMySQL dao;

	@Test
	public void defaultConstructorTest() {
		dao = new BookDAOMySQL();

		assertThat(dao, is(notNullValue()));
	}

	@Test
	public void dependencyConstructorTest() {
		DBConnectorMySQL connector = new DBConnectorMySQL();
		dao = new BookDAOMySQL(connector);

		assertThat(dao, is(notNullValue()));
	}

	@Test
	public void successfulGetLocationsFromBookTest() throws ConnectionAlreadyClosedException {
		BookDAOMySQL dao = mock(BookDAOMySQL.class);
		List<Location> locations = new ArrayList<>();
		locations.add(new Location(1L, "latitude", "longitude", "name"));

		when(dao.getCitiesFromBook(anyString())).
				thenReturn(locations);

		assertThat(dao.getCitiesFromBook(anyString()),is(locations));
	}

	@Test
	public void failedGetLocationsFromBookTest() throws ConnectionAlreadyClosedException {
		BookDAOMySQL dao = mock(BookDAOMySQL.class);
		when(dao.getCitiesFromBook(anyString())).
				thenReturn(null);

		assertThat(dao.getCitiesFromBook(anyString()), is(nullValue()));
	}

	@Test
    public void successfulGetBooksAndCitiesFromAuthorTest() throws ConnectionAlreadyClosedException {
	    List<Book> books = new ArrayList<>();

	    BookDAOMySQL dao = mock(BookDAOMySQL.class);
	    when(dao.getBooksAndCitiesFromAuthor(anyString())).
                thenReturn(books);

	    assertThat(dao.getBooksAndCitiesFromAuthor(anyString()), is(books));
    }

    @Test
    public void failedGetBooksAndCitiesFromAuthorTest() throws ConnectionAlreadyClosedException {
	    BookDAOMySQL dao = mock(BookDAOMySQL.class);
	    when(dao.getBooksAndCitiesFromAuthor(anyString())).
                thenReturn(null);

	    assertThat(dao.getBooksAndCitiesFromAuthor(anyString()), is(nullValue()));
    }

    @Test
	public void successfulGetBooksFromLatitudeLongitudeTest() throws ConnectionAlreadyClosedException {
		List<Book> books = new ArrayList<>();

		BookDAOMySQL dao = mock(BookDAOMySQL.class);
		when(dao.getBooksFromLatLong(anyString(), anyString(),  anyInt())).
				thenReturn(books);

		assertThat(dao.getBooksFromLatLong(anyString(), anyString(), anyInt()), is(books));
	}

	@Test
	public void failedGetBooksFromLatitudeLongitudeTest() throws ConnectionAlreadyClosedException {
		BookDAOMySQL dao = mock(BookDAOMySQL.class);
		when(dao.getBooksFromLatLong(anyString(),anyString(), anyInt())).
				thenReturn(null);

		assertThat(dao.getBooksFromLatLong(anyString(),anyString(),anyInt()), is(nullValue()));
	}

	@Test
	public void successfulGetAuthorsAndBooksFromCities() throws ConnectionAlreadyClosedException {
		List<Book> books = new ArrayList<>();

		BookDAOMySQL dao = mock(BookDAOMySQL.class);
		Location location = new Location();
		when(dao.getAuthorsAndBooksFromCity(location)).
				thenReturn(books);

		assertThat(dao.getAuthorsAndBooksFromCity(location), is(books));
	}

	@Test
	public void failedGetAuthorsAndBooksFromCities() throws ConnectionAlreadyClosedException {
		BookDAOMySQL dao = mock(BookDAOMySQL.class);
		Location location = new Location();
		when(dao.getAuthorsAndBooksFromCity(location)).
				thenReturn(null);

		assertThat(dao.getAuthorsAndBooksFromCity(location), is(nullValue()));
	}
}
