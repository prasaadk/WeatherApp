package org.weatherapp.openweather.impl;

import org.weatherapp.openweather.api.IOpenWeatherAPIUrlBuilder;

/**
 * This class manages how Web API URLs should be build for different kind of api
 * requests.
 * 
 * @author prasad
 * 
 */
public class OpenWeatherAPIUrlBuilder implements IOpenWeatherAPIUrlBuilder {

	private OpenWeatherAPIConfiguration details;

	public OpenWeatherAPIUrlBuilder(OpenWeatherAPIConfiguration openWeatherAPIDetails) {
		this.details = openWeatherAPIDetails;
	}

	@Override
	public String buildUrlForCityName(String cityName) {
		return OpenWeatherAPIUtils.buildUrlForCityName(details, cityName);
	}

	@Override
	public String buildUrlForCityId(String cityId) {
		return OpenWeatherAPIUtils.buildUrlForCityId(details, cityId);
	}

	@Override
	public String buildUrlForIcon(String code) {
		return OpenWeatherAPIUtils.buildUrlForIcon(details, code);
	}

}
