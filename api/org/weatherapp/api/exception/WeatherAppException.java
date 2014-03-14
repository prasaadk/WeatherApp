package org.weatherapp.api.exception;


public class WeatherAppException extends Exception {

	public WeatherAppException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeatherAppException(String message) {
		super(message);
	}
	
}

