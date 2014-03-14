package org.weatherapp.impl.vo;

public class WeatherCondition {
	private int id;
	private String main;
	private String description;
	private String icon;

	public WeatherCondition() {
		// empty constructor for Gson to build object from json
	}
	
	public WeatherCondition(int id, String main, String description, String icon) {
		// convenience constructor, currently used for tests
		this.id = id;
		this.main = main;
		this.description = description;
		this.icon = icon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	@Override
	public String toString() {
		return "Weather [id=" + id + ", main=" + main + ", description="
				+ description + ", icon=" + icon + "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
