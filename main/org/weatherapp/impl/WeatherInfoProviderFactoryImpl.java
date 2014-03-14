package org.weatherapp.impl;

import org.weatherapp.api.IWeatherInfoProvider;
import org.weatherapp.api.IWeatherInfoProviderFactory;
import org.weatherapp.openweather.api.IOpenWeatherAPIReader;

public class WeatherInfoProviderFactoryImpl implements
		IWeatherInfoProviderFactory {

	private IOpenWeatherAPIReader apiReader;

	public WeatherInfoProviderFactoryImpl(IOpenWeatherAPIReader apiReader) {
		this.apiReader = apiReader;
	}

	@Override
	public IWeatherInfoProvider getProvider() {
		return new WeatherInfoProviderImpl(apiReader);
	}

}
