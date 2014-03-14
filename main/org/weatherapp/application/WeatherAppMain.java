package org.weatherapp.application;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.weatherapp.api.ICityListProvider;
import org.weatherapp.api.IWeatherInfoProviderFactory;
import org.weatherapp.impl.ConfiguredCitiesProvider;
import org.weatherapp.impl.WeatherInfoProviderFactoryImpl;
import org.weatherapp.impl.view.WeatherApp;
import org.weatherapp.openweather.api.IOpenWeatherAPIReader;
import org.weatherapp.openweather.api.IOpenWeatherAPIUrlBuilder;
import org.weatherapp.openweather.impl.OpenWeatherAPIConfiguration;
import org.weatherapp.openweather.impl.OpenWeatherAPIReader;
import org.weatherapp.openweather.impl.OpenWeatherAPIUrlBuilder;

public class WeatherAppMain {
	private static JFrame frame;

	public static final String API_URI = "http://api.openweathermap.org/data/2.5/weather";
	public static final String IMG_URI = "http://openweathermap.org/img/w/";

	public static void main(String args[]) throws Exception {
		// This will provide the list of configured cities
		ICityListProvider configuredCities = new ConfiguredCitiesProvider();

		IOpenWeatherAPIUrlBuilder urlBuilder = new OpenWeatherAPIUrlBuilder(
				new OpenWeatherAPIConfiguration(API_URI, IMG_URI));
		IOpenWeatherAPIReader apiReader = new OpenWeatherAPIReader(urlBuilder);
		IWeatherInfoProviderFactory weatherInfoProviderFactory = new WeatherInfoProviderFactoryImpl(
				apiReader);

		// Here comes the display part that lets user choose a City
		frame = new JFrame("Weather App");
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setContentPane(new WeatherApp(configuredCities,
				weatherInfoProviderFactory));
		frame.pack();
		frame.setVisible(true);
	}
}
