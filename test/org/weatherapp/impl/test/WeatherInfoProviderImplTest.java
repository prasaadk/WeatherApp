package org.weatherapp.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.Reader;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.weatherapp.impl.WeatherInfoProviderImpl;
import org.weatherapp.impl.vo.City;
import org.weatherapp.impl.vo.WeatherInfo;
import org.weatherapp.openweather.api.IOpenWeatherAPIReader;

public class WeatherInfoProviderImplTest {

	private IOpenWeatherAPIReader apiReader;

	@Before
	public void setUp() {
		apiReader = Mockito.mock(IOpenWeatherAPIReader.class);
	}

	@Test
	public void testEmptyJson() throws Exception {
		String cityName = "Foo";
		Mockito.doReturn(reader("{}")).when(apiReader)
				.getWeatherInfoResponseCityName(cityName);

		WeatherInfoProviderImpl provider = new WeatherInfoProviderImpl(
				apiReader);

		WeatherInfo info = provider.getWeatherInfo(new City(cityName));
		assertNull("name should be null", info.getName());
		assertNull("coordinates should be null", info.getCoord());
		assertNull("main should be null", info.getMain());
		assertNull("weather should be null", info.getWeather());
		assertNull("message should be null", info.getMessage());
		assertEquals("cod should be null", 0, info.getCod());
	}

	@Test
	public void testOnlyFewErrorFields() throws Exception {
		String cityName = "Foo";
		String message = "Error: Not found city";
		String json = "{\"message\":\"" + message + "\",\"cod\":\"404\"}";
		Mockito.doReturn(reader(json)).when(apiReader)
				.getWeatherInfoResponseCityName(cityName);

		WeatherInfoProviderImpl provider = new WeatherInfoProviderImpl(
				apiReader);

		WeatherInfo info = provider.getWeatherInfo(new City(cityName));
		assertNull("name should be null", info.getName());
		assertNull("coordinates should be null", info.getCoord());
		assertNull("main should be null", info.getMain());
		assertNull("weather should be null", info.getWeather());
		assertEquals("message should not be null", message, info.getMessage());
		assertEquals("cod should be 404", 404, info.getCod());
	}

	@Test
	public void testGetImageIcon() throws Exception {
		WeatherInfoProviderImpl provider = new WeatherInfoProviderImpl(
				apiReader);

		provider.getWeatherIcon("code", "description");

		Mockito.verify(apiReader, Mockito.times(1)).getWeatherIconForCode(
				"code", "description");
	}

	private Reader reader(String json) {
		return new StringReader(json);
	}

}
