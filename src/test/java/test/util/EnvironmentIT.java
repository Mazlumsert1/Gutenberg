package test.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class EnvironmentIT {

	@Test
	public void testMySQLEnvironmentVariables() {
		assertThat(System.getenv("MYSQL_USER"), is(notNullValue()));
		assertThat(System.getenv("MYSQL_PWD"), is(notNullValue()));
		assertThat(System.getenv("MYSQL_URI"), is(notNullValue()));
	}

	@Test
	public void testProcessEnvironmentVariable() {
		assertThat(System.getenv("PROCESS_ENV"), either(is("dev")).or(is("prod")));
	}

}
