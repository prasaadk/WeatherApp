package org.weatherapp.openweather.api;


/**
 * Interface to have Open Weather API URL building logic for given details
 * 
 * @author prasad
 */
public interface IOpenWeatherAPIUrlBuilder {

	/**
	 * Builds API URL for CityName query
	 */
	public String buildUrlForCityName(String cityName);

	/**
	 * 
	 * @param details
	 * @param cityId
	 * @return
	 */
	public String buildUrlForCityId(String cityId);

	/**
	 * 
	 * @param details
	 * @param code
	 * @return
	 */
	public String buildUrlForIcon(String code);

}
