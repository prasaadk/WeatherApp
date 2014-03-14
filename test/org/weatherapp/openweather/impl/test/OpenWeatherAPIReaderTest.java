package org.weatherapp.openweather.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.weatherapp.api.exception.WeatherAppException;
import org.weatherapp.openweather.api.IOpenWeatherAPIUrlBuilder;
import org.weatherapp.openweather.impl.OpenWeatherAPIReader;

public class OpenWeatherAPIReaderTest {

	IOpenWeatherAPIUrlBuilder urlBuilder;

	@Before
	public void setUp() throws Exception {
		urlBuilder = Mockito.mock(IOpenWeatherAPIUrlBuilder.class);
	}

	@Test
	public void testGetWeatherInfoByCityName() throws Exception {
		String cityName = "Foo";
		String json = "dummyResponse.json";
		Mockito.doReturn(
				OpenWeatherAPIReaderTest.class.getResource(json).toString())
				.when(urlBuilder).buildUrlForCityName(cityName);

		OpenWeatherAPIReader reader = new OpenWeatherAPIReader(urlBuilder);
		assertEquals("file content should be the same",
				IOUtils.toString(OpenWeatherAPIReaderTest.class
						.getResource(json)), IOUtils.toString(reader
						.getWeatherInfoResponseCityName(cityName)));

	}

	@Test
	public void testMalformedUrlForWeatherInfoByName() throws Exception {
		String cityName = "Foo";
		Mockito.doReturn("this is invalid url").when(urlBuilder)
				.buildUrlForCityName(cityName);

		OpenWeatherAPIReader reader = new OpenWeatherAPIReader(urlBuilder);

		try {
			reader.getWeatherInfoResponseCityName(cityName);
			fail("should throw exception");
		} catch (WeatherAppException e) {
			assertTrue("cause should be malformed url exception",
					e.getCause() instanceof MalformedURLException);
		}
	}

	@Test
	public void testExceptionWhileReadingURLContentForWeatherInfoByName()
			throws Exception {
		String cityName = "Foo";
		Mockito.doReturn("file:///home/doesNotExist.json").when(urlBuilder)
				.buildUrlForCityName(cityName);

		OpenWeatherAPIReader reader = new OpenWeatherAPIReader(urlBuilder);

		try {
			reader.getWeatherInfoResponseCityName(cityName);
			fail("should throw some exception");
		} catch (WeatherAppException e) {
			assertTrue("cause should be IO Exception",
					e.getCause() instanceof IOException);
		}
	}

	@Test
	public void testMalformedUrlForWeatherInfoById() throws Exception {
		String cityId = "Foo";
		Mockito.doReturn("this is invalid url").when(urlBuilder)
				.buildUrlForCityId(cityId);

		OpenWeatherAPIReader reader = new OpenWeatherAPIReader(urlBuilder);

		try {
			reader.getWeatherInfoResponseCityId(cityId);
			fail("should throw exception");
		} catch (WeatherAppException e) {
			assertTrue("cause should be malformed url exception",
					e.getCause() instanceof MalformedURLException);
		}
	}

	@Test
	public void testExceptionWhileReadingURLContentForWeatherInfoById()
			throws Exception {
		String cityName = "Foo";
		Mockito.doReturn("file:///home/doesNotExist.json").when(urlBuilder)
				.buildUrlForCityId(cityName);

		OpenWeatherAPIReader reader = new OpenWeatherAPIReader(urlBuilder);

		try {
			reader.getWeatherInfoResponseCityId(cityName);
			fail("should throw some exception");
		} catch (WeatherAppException e) {
			assertTrue("cause should be IO Exception",
					e.getCause() instanceof IOException);
		}
	}

	@Test
	public void testGetWeatherInfoByCityId() throws Exception {
		String cityId = "Foo";
		String json = "dummyResponse.json";
		Mockito.doReturn(
				OpenWeatherAPIReaderTest.class.getResource(json).toString())
				.when(urlBuilder).buildUrlForCityId(cityId);

		OpenWeatherAPIReader reader = new OpenWeatherAPIReader(urlBuilder);
		assertEquals("file content should be the same",
				IOUtils.toString(OpenWeatherAPIReaderTest.class
						.getResource(json)), IOUtils.toString(reader
						.getWeatherInfoResponseCityId(cityId)));
	}

	@Test
	public void testGetWeatherIconForWeatherCode() throws Exception {
		String code = "10d";
		String description = "some description";
		String img = "tux.png";
		Mockito.doReturn(
				OpenWeatherAPIReaderTest.class.getResource(img).toString())
				.when(urlBuilder).buildUrlForIcon(code);

		OpenWeatherAPIReader reader = new OpenWeatherAPIReader(urlBuilder);
		assertEquals("should be the same images",
				new ImageIcon(OpenWeatherAPIReaderTest.class.getResource(img),
						description).getImage(),
				reader.getWeatherIconForCode(code, description).getImage());
	}

	@Test
	public void testMalformedUrlForGetWeatherIconForWeatherCode()
			throws Exception {
		String code = "10d";
		String description = "some description";
		Mockito.doReturn("this is invalid url").when(urlBuilder)
				.buildUrlForIcon(code);

		OpenWeatherAPIReader reader = new OpenWeatherAPIReader(urlBuilder);

		try {
			reader.getWeatherIconForCode(code, description);
			fail("should throw some exception");
		} catch (WeatherAppException e) {
			assertTrue("cause should be IO Exception",
					e.getCause() instanceof IOException);
		}
	}

}
