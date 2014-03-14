package org.weatherapp.openweather.api;

import java.io.Reader;

import javax.swing.ImageIcon;

import org.weatherapp.api.exception.WeatherAppException;

/**
 * Interface for reading Open Weather API
 * @author prasad
 */
public interface IOpenWeatherAPIReader {
	
	/**
	 * Gets response from Open Weather API query by city name
	 * @throws WeatherAppException
	 */
	Reader getWeatherInfoResponseCityName(String cityName) throws WeatherAppException;
	
	/**
	 * Gets response from Open Weather API query by cityId
	 * @throws WeatherAppException
	 */
	Reader getWeatherInfoResponseCityId(String cityId) throws WeatherAppException;

	/**
	 * Gets Weather icon for the given icon code
	 * @param description 
	 * @return {@link ImageIcon}
	 * @throws WeatherAppException 
	 */
	ImageIcon getWeatherIconForCode(String code, String description) throws WeatherAppException;
	
}
