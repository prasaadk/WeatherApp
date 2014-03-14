package org.weatherapp.openweather.impl;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

import org.apache.commons.io.IOUtils;
import org.weatherapp.api.exception.WeatherAppException;
import org.weatherapp.openweather.api.IOpenWeatherAPIReader;
import org.weatherapp.openweather.api.IOpenWeatherAPIUrlBuilder;

/**
 * This class handles communication with the Web API
 * 
 * @author prasad
 */
public class OpenWeatherAPIReader implements IOpenWeatherAPIReader {

	private IOpenWeatherAPIUrlBuilder urlBuilder;

	public OpenWeatherAPIReader(IOpenWeatherAPIUrlBuilder urlBuilder) {
		this.urlBuilder = urlBuilder;
	}

	@Override
	public Reader getWeatherInfoResponseCityName(String cityName)
			throws WeatherAppException {
		try {
			return new StringReader(IOUtils.toString(new URL(urlBuilder
					.buildUrlForCityName(cityName))));
		} catch (MalformedURLException e) {
			throw new WeatherAppException(
					"Exception while fetching weather information for '"
							+ cityName + "'", e);
		} catch (IOException e) {
			throw new WeatherAppException(
					"Exception while fetching weather information for '"
							+ cityName + "'", e);
		}
	}

	@Override
	public Reader getWeatherInfoResponseCityId(String cityId)
			throws WeatherAppException {
		try {
			return new StringReader(IOUtils.toString(new URL(urlBuilder
					.buildUrlForCityId(cityId))));
		} catch (MalformedURLException e) {
			throw new WeatherAppException(
					"Exception while fetching weather information for '"
							+ cityId + "'", e);
		} catch (IOException e) {
			throw new WeatherAppException(
					"Exception while fetching weather information for '"
							+ cityId + "'", e);
		}
	}

	@Override
	public ImageIcon getWeatherIconForCode(String code, String description)
			throws WeatherAppException {
		try {
			return new ImageIcon(new URL(urlBuilder.buildUrlForIcon(code)),
					description);
		} catch (MalformedURLException e) {
			throw new WeatherAppException(
					"Exception while fetching weather icon for '" + code + "'",
					e);
		}
	}

}
