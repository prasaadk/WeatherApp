package org.weatherapp.api;

import java.util.Set;

import org.weatherapp.impl.vo.City;

/**
 * Interface to provide list of {@link City} objects. 
 * @author prasad
 */
public interface ICityListProvider {
	
	/**
	 * Get list of cities
	 * @return
	 */
	public Set<City> getCities();
}
