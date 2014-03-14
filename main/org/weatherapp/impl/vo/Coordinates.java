package org.weatherapp.impl.vo;

public class Coordinates {
	private double lon;
	private double lat;

	public Coordinates() {
		// empty constructor for Gson to build object from json
	}
	
	public Coordinates(double lon, double lat) {
		// convenience constructor, currently used for tests
		this.lon = lon;
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "Coordinates [lon=" + lon + ", lat=" + lat + "]";
	}
}
