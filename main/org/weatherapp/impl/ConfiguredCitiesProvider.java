package org.weatherapp.impl;

import java.util.Set;

import org.weatherapp.api.ICityListProvider;
import org.weatherapp.impl.vo.City;

import com.google.common.collect.Sets;

/**
 * For the sake of test application, this class with hard-coded values has been
 * created. Given the simplicity of this class, test hasn't been provided
 * although if this becomes a complex entity a test is a must. In ideal
 * scenario, such city list provider implementation can read from config files,
 * databases or any web API. This provides separation of concern for where the
 * list is coming from for the rest of the application
 * 
 * @author prasad
 * 
 */
public class ConfiguredCitiesProvider implements ICityListProvider {

	@Override
	public Set<City> getCities() {
		return Sets.newHashSet(city("London"), city("Luton"),
				city("Manchester"), city("Birmingham"));
	}

	private City city(String cityName) {
		return new City(cityName);
	}

}
