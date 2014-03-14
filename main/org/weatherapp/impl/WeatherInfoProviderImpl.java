package org.weatherapp.impl;


import java.io.Reader;

import javax.swing.ImageIcon;

import org.weatherapp.api.IWeatherInfoProvider;
import org.weatherapp.api.exception.WeatherAppException;
import org.weatherapp.impl.vo.City;
import org.weatherapp.impl.vo.WeatherInfo;
import org.weatherapp.openweather.api.IOpenWeatherAPIReader;

import com.google.gson.Gson;

public class WeatherInfoProviderImpl implements IWeatherInfoProvider {
	
	private IOpenWeatherAPIReader apiReader;

	public WeatherInfoProviderImpl(IOpenWeatherAPIReader apiReader) {
		this.apiReader = apiReader;		
	}
	
	@Override
	public WeatherInfo getWeatherInfo(City city) throws WeatherAppException {
		Reader reader = apiReader.getWeatherInfoResponseCityName(city.getName());		
		WeatherInfo info = new Gson().fromJson(reader,
				WeatherInfo.class);
		return info;
	}
	
	@Override
	public ImageIcon getWeatherIcon(String code, String description)
			throws WeatherAppException {
		return apiReader.getWeatherIconForCode(code, description);
	}

}
