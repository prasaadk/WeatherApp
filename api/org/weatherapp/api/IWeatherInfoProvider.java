package org.weatherapp.api;

import javax.swing.ImageIcon;

import org.weatherapp.api.exception.WeatherAppException;
import org.weatherapp.impl.vo.City;
import org.weatherapp.impl.vo.WeatherInfo;

/**
 * This is interface that can provide WeatherInfo
 * @author prasad
 */
public interface IWeatherInfoProvider {

	/**
	 * Returns populated {@link WeatherInfo} for the given City
	 * @param city
	 * @return {@link WeatherInfo}
	 * @throws WeatherAppException
	 */
	WeatherInfo getWeatherInfo(City city) throws WeatherAppException;

	/**
	 * Returns image icon for the given weather code
	 * @throws WeatherAppException
	 */
	ImageIcon getWeatherIcon(String code, String description)
			throws WeatherAppException;

}
