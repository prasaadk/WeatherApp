package org.weatherapp.openweather.impl.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.weatherapp.openweather.impl.OpenWeatherAPIConfiguration;
import org.weatherapp.openweather.impl.OpenWeatherAPIUrlBuilder;

public class OpenWeatherAPIUrlBuilderTest {

	private static final String IMG_URI = "http://imgUri/";
	private static final String API_URI = "http://apiUri";

	OpenWeatherAPIConfiguration openWeatherAPIDetails;
	private OpenWeatherAPIUrlBuilder urlBuilder;

	@Before
	public void setUp() {
		openWeatherAPIDetails = new OpenWeatherAPIConfiguration(API_URI,
				IMG_URI);
		urlBuilder = new OpenWeatherAPIUrlBuilder(openWeatherAPIDetails);
	}

	@Test
	public void testUrlBuildingForQueryByCityName() {
		assertEquals("should be equal", API_URI + "?q=Foo",
				urlBuilder.buildUrlForCityName("Foo"));
	}

	@Test
	public void testUrlBuildingForQueryByCityId() {
		assertEquals("should be equal", API_URI + "?id=FooId",
				urlBuilder.buildUrlForCityId("FooId"));
	}

	@Test
	public void testUrlBuildingForImageIcon() {
		assertEquals("should be equal", IMG_URI + "10d.png",
				urlBuilder.buildUrlForIcon("10d"));
	}

}
