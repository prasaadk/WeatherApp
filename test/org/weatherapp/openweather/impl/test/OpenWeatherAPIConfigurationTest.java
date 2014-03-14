package org.weatherapp.openweather.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.weatherapp.openweather.impl.OpenWeatherAPIConfiguration;

public class OpenWeatherAPIConfigurationTest {

	@Test
	public void testOpenWeatherAPIDetailsWiring() {
		String apiUri = "http://weburi";
		String imgUri = "http://imageuri";
		OpenWeatherAPIConfiguration apiDetails = new OpenWeatherAPIConfiguration(apiUri,
				imgUri);
		assertEquals("api uri should match", apiUri, apiDetails.getApiURI());
		assertEquals("img uri should match", imgUri, apiDetails.getImgUri());
	}
}
