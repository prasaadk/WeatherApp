package org.weatherapp.impl.view;

import java.util.List;

import javax.swing.ImageIcon;

import org.weatherapp.api.IWeatherInfoProvider;
import org.weatherapp.api.exception.WeatherAppException;
import org.weatherapp.impl.vo.City;
import org.weatherapp.impl.vo.WeatherCondition;
import org.weatherapp.impl.vo.WeatherInfo;

/**
 * This is model for the {@link WeatherApp} panel. This pulls out information
 * from the {@link IWeatherInfoProvider} and makes required information
 * available for presentation
 * 
 * @author prasad
 */
public class WeatherAppInfoModel {

	private WeatherInfo info;
	private IWeatherInfoProvider weatherInfoProvider;

	public WeatherAppInfoModel(IWeatherInfoProvider weatherInfoProvider,
			City city) throws WeatherAppException {
		this.weatherInfoProvider = weatherInfoProvider;
		this.info = weatherInfoProvider.getWeatherInfo(city);
	}

	public String getName() {
		return "Name: " + info.getName();
	}

	public String getLocationInfo() {
		return "Latitude: " + info.getCoord().getLat() + ", Longitude: "
				+ info.getCoord().getLon();
	}

	public String getCurrentWeatherConditions() {
		List<WeatherCondition> weatherConditions = info.getWeather();
		StringBuilder builder = new StringBuilder();
		for (WeatherCondition weather : weatherConditions) {
			builder.append(weather.getMain()).append(", ")
					.append(weather.getDescription()).append("\n");
		}
		return builder.toString();
	}

	public String getTemperate() {
		return "Temperate: " + info.getMain().getTemp();
	}
	
	public String getTemperatureRange() {
		return "Temperate, Min: " + info.getMain().getTemp_min() + ", Max: "
				+ info.getMain().getTemp_max();
	}

	public String getCurrentAtmosphericPressure() {
		return "Pressure: " + info.getMain().getPressure();
	}

	public String getHumidity() {
		return "Humidity: " + info.getMain().getHumidity();
	}

	public ImageIcon getWeatherIcon() {
		try {
			return weatherInfoProvider.getWeatherIcon(info.getWeather().get(0)
					.getIcon(), info.getWeather().get(0).getDescription());
		} catch (WeatherAppException e) {
			// Unable to fetch weather Icon, return null or ideally return a
			// blank or neutral icon
			return null;
		}
	}

}
