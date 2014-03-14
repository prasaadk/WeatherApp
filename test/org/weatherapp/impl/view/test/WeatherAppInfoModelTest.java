package org.weatherapp.impl.view.test;

import static org.junit.Assert.assertEquals;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.weatherapp.api.IWeatherInfoProvider;
import org.weatherapp.api.exception.WeatherAppException;
import org.weatherapp.impl.view.WeatherAppInfoModel;
import org.weatherapp.impl.vo.City;
import org.weatherapp.impl.vo.Coordinates;
import org.weatherapp.impl.vo.Main;
import org.weatherapp.impl.vo.WeatherCondition;
import org.weatherapp.impl.vo.WeatherInfo;

import com.google.common.collect.Lists;

public class WeatherAppInfoModelTest {
	
	IWeatherInfoProvider weatherInfoProvider;
	
	@Before
	public void setUp() throws Exception {
		weatherInfoProvider = Mockito.mock(IWeatherInfoProvider.class);
	}
	
	@Test
	public void testWeatherInfoDetails() throws Exception {	
		City city = new City("Foo");
		WeatherInfo weatherInfo = new WeatherInfo();
		weatherInfo.setName("Foo");		
		weatherInfo.setCoord(new Coordinates(23.4, 54.2));
		weatherInfo.setMain(new Main(0, 44, 33, -1,3));
		weatherInfo.setWeather(Lists.newArrayList(new WeatherCondition(500,
				"Haze", "some description", "10d")));		
		
		Mockito.doReturn(weatherInfo).when(weatherInfoProvider).getWeatherInfo(city);
		ImageIcon imageIcon = new ImageIcon("tux.png");
		Mockito.doReturn(imageIcon).when(weatherInfoProvider)
				.getWeatherIcon("10d", "some description");
		
		WeatherAppInfoModel model = new WeatherAppInfoModel(weatherInfoProvider, city);
		
		assertEquals("name label should be equal", "Name: Foo", model.getName());
		assertEquals("LocationInfo label should be equal", "Latitude: 54.2, Longitude: 23.4", model.getLocationInfo());
		assertEquals("weather conditions label should match", "Haze, some description\n", model.getCurrentWeatherConditions());
		assertEquals("humidity label should match", "Humidity: 33.0", model.getHumidity());
		assertEquals("temperature should match", "Temperate: 0.0", model.getTemperate());
		assertEquals("temperature range label should match", "Temperate, Min: -1.0, Max: 3.0", model.getTemperatureRange());
		assertEquals("current atmospheric pressure label should match", "Pressure: 44.0", model.getCurrentAtmosphericPressure());
		assertEquals("weather icon should match", imageIcon,model.getWeatherIcon());		
	}
	
	@Test
	public void testWeatherIconNotFound() throws Exception {
		City city = new City("Foo");
		WeatherInfo weatherInfo = new WeatherInfo();
		weatherInfo.setName("Foo");		
		weatherInfo.setCoord(new Coordinates(23.4, 54.2));
		weatherInfo.setMain(new Main(0, 44, 33, -1,3));
		weatherInfo.setWeather(Lists.newArrayList(new WeatherCondition(500,
				"Haze", "some description", "10d")));		
		
		Mockito.doReturn(weatherInfo).when(weatherInfoProvider).getWeatherInfo(city);
		Throwable weatherException = new WeatherAppException("some problem");
		Mockito.doThrow(weatherException).when(weatherInfoProvider)
				.getWeatherIcon("10d", "some description");
		
		WeatherAppInfoModel model = new WeatherAppInfoModel(weatherInfoProvider, city);
		
		assertEquals("name label should be equal", "Name: Foo", model.getName());
		assertEquals("LocationInfo label should be equal", "Latitude: 54.2, Longitude: 23.4", model.getLocationInfo());
		assertEquals("weather conditions label should match", "Haze, some description\n", model.getCurrentWeatherConditions());
		assertEquals("humidity label should match", "Humidity: 33.0", model.getHumidity());
		assertEquals("temperature should match", "Temperate: 0.0", model.getTemperate());
		assertEquals("temperature range label should match", "Temperate, Min: -1.0, Max: 3.0", model.getTemperatureRange());
		assertEquals("current atmospheric pressure label should match", "Pressure: 44.0", model.getCurrentAtmosphericPressure());
		assertEquals("weather icon should match", null,model.getWeatherIcon());
	}

}
