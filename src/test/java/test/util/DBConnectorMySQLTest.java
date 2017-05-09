package test.util;

import main.util.DBConnectorMySQL;
import main.util.IDBConnectorMySQL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DBConnectorMySQLTest {

	private IDBConnectorMySQL connector;

	@Test
	public void testDefaultConstructor() {
		connector = new DBConnectorMySQL();
		assertThat(connector, is(notNullValue()));
	}

	@Test
	public void testDependencyInjectionConstructor() {
		connector = new DBConnectorMySQL("driver", "uri", "user", "password");
		assertThat(connector, is(notNullValue()));
	}

}
