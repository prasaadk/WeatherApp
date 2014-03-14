package org.weatherapp.api;

/**
 * Creates {@link IWeatherInfoProvider}
 * @author prasad
 *
 */
public interface IWeatherInfoProviderFactory {

	/**
	 * Creates {@link IWeatherInfoProvider}
	 * @return
	 */
	IWeatherInfoProvider getProvider();

}
