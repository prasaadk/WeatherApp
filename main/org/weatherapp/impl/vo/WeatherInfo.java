package org.weatherapp.impl.vo;

import java.util.List;

public class WeatherInfo {
	// name
	private String name;

	// latitude and longitude
	private Coordinates coord;

	// weather conditions
	private List<WeatherCondition> weather;
	private Main main;

	// message
	private String message;
	// code
	private int cod;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public List<WeatherCondition> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherCondition> weather) {
		this.weather = weather;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@Override
	public String toString() {
		return "WeatherInfo [name=" + name + ", coord=" + coord + ", weather="
				+ weather + ", main=" + main + "]";
	}
}
