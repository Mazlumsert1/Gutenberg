package test.dto;

import main.dto.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LocationTest {

	private Location location;

	@Test
	public void testEmptyConstructor() {
		location = new Location();

		assertThat(location.getLatitude(), is(0.0));
		assertThat(location.getLongitude(), is(0.0));
		assertThat(location.getName(), is(nullValue()));
	}

	@Test
	public void testConstructor() {
		location = new Location(55.676097, 12.568337, "Copenhagen");

		assertThat(location.getLatitude(), is(55.676097));
		assertThat(location.getLongitude(), is(12.568337));
		assertThat(location.getName(), is("Copenhagen"));
	}

	@Test
	public void testSetters() {
		location = new Location(55.676097, 12.568337, "Copenhagen");
		location.setLatitude(54.990776);
		location.setLongitude(9.282406);
		location.setName("Bolderslev");

		assertThat(location.getLatitude(), is(54.990776));
		assertThat(location.getLongitude(), is(9.282406));
		assertThat(location.getName(), is("Bolderslev"));
	}
}
