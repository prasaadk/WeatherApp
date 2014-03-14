package org.weatherapp.openweather.impl;


public class OpenWeatherAPIUtils {
	/**
	 * Builds API URL for CityName query
	 */
	public static String buildUrlForCityName(OpenWeatherAPIConfiguration details,
			String cityName) {
		StringBuilder builder = new StringBuilder();
		builder.append(details.getApiURI()).append("?q=").append(cityName);
		return builder.toString();
	}

	/**
	 * Builds API URL for CityId query
	 */
	public static String buildUrlForCityId(OpenWeatherAPIConfiguration details, String cityId) {
		StringBuilder builder = new StringBuilder();
		builder.append(details.getApiURI()).append("?id=").append(cityId);
		return builder.toString();
	}

	public static String buildUrlForIcon(OpenWeatherAPIConfiguration details,
			String code) {
		StringBuilder builder = new StringBuilder();
		builder.append(details.getImgUri()).append(code).append(".png");
		return builder.toString();
	}
}
