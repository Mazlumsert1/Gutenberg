package test.util;

import main.util.DBConnectorMongo;
import main.util.IDBConnectorMongo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DBConnectorMongoTest {
	private IDBConnectorMongo connector;

	@Test
	public void defaultConstructorTest() {
		connector = new DBConnectorMongo();

		assertThat(connector, is(notNullValue()));
	}

	@Test
	public void testDependencyInjectionConstructor() {
		connector = new DBConnectorMongo("uri", "user", "password", "db");
		assertThat(connector, is(notNullValue()));
	}

}
