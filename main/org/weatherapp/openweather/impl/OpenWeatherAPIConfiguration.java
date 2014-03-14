package org.weatherapp.openweather.impl;

/**
 * Configuration object to hold the Web API configuration details
 * 
 * @author prasad
 * 
 */
public class OpenWeatherAPIConfiguration {

	private String apiUri;
	private String imgUri;

	public OpenWeatherAPIConfiguration(String apiUri, String imgUri) {
		this.apiUri = apiUri;		
		this.imgUri = imgUri;
	}
	
	/**
	 * Returns Web API URI
	 */
	public String getApiURI() {
		return apiUri;
	}

	/**
	 * Returns Web API URI to fetch images
	 */
	public String getImgUri() {
		return imgUri;
	}
		
}
