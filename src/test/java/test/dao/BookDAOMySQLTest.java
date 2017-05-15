package test.dao;

import main.dao.BookDAOMySQL;
import main.dto.Author;
import main.dto.Book;
import main.dto.Location;
import main.exception.BookNotFoundException;
import main.util.DBConnectorMySQL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
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
	public void successfulGetLocationsFromBookTest() {
		BookDAOMySQL dao = mock(BookDAOMySQL.class);
		List<Location> locations = new ArrayList<>();
		locations.add(new Location(1L, "latitude", "longitude", "name"));

		when(dao.getCitiesFromBook(anyString())).
				thenReturn(locations);

		assertThat(dao.getCitiesFromBook(anyString()),is(locations));
	}

	@Test
	public void failedGetLocationsFromBookTest() {
		BookDAOMySQL dao = mock(BookDAOMySQL.class);
		when(dao.getCitiesFromBook(anyString())).
				thenReturn(null);

		assertThat(dao.getCitiesFromBook(anyString()), is(nullValue()));
	}

	@Test
    public void successfulGetBooksAndCitiesFromAuthor() {
	    List<Book> books = new ArrayList<>();

	    BookDAOMySQL dao = mock(BookDAOMySQL.class);
	    when(dao.getBooksAndCitiesFromAuthor(anyString())).
                thenReturn(books);

	    assertThat(dao.getBooksAndCitiesFromAuthor(anyString()), is(books));
    }

    @Test
    public void failedGetBooksAndCitiesFromAuthor() {
	    BookDAOMySQL dao = mock(BookDAOMySQL.class);
	    when(dao.getBooksAndCitiesFromAuthor(anyString())).
                thenReturn(null);

	    assertThat(dao.getBooksAndCitiesFromAuthor(anyString()), is(nullValue()));
    }
}
