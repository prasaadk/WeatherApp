package org.weatherapp.impl.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.weatherapp.api.ICityListProvider;
import org.weatherapp.api.IWeatherInfoProviderFactory;
import org.weatherapp.api.exception.WeatherAppException;
import org.weatherapp.impl.vo.City;

/**
 * @author prasad
 */
public class WeatherApp extends JPanel {

	private static final int DEFAULT_SELECTION = 0;

	// Combo box widget
	JComboBox<String> comboCitiesList;

	// Info panel member widgets
	JLabel name;
	JLabel location;
	JLabel currentWeatherConditions;
	JLabel weatherIcon;
	JLabel temperate;
	JLabel temperatureRange;
	JLabel currentAtmosphericPressure;
	JLabel humidity;

	public WeatherApp(ICityListProvider cityListProvider,
			final IWeatherInfoProviderFactory weatherInfoProviderFactory) {

		Vector<String> cities = createCityNamesVector(cityListProvider);

		createAndConfigureCityComboBox(weatherInfoProviderFactory, cities);
		createInfoPanel();

		// populating the info panel for initial selection
		updateInfoForCity(weatherInfoProviderFactory,
				cities.get(DEFAULT_SELECTION));

	}

	private void createInfoPanel() {
		JPanel infoPanel = new JPanel();
		add(infoPanel, BorderLayout.CENTER);

		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		name = new JLabel();
		infoPanel.add(name);

		location = new JLabel();
		infoPanel.add(location);

		currentWeatherConditions = new JLabel();
		infoPanel.add(currentWeatherConditions);

		weatherIcon = new JLabel();
		infoPanel.add(weatherIcon);

		weatherIcon.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

		weatherIcon.setPreferredSize(new Dimension(177, 122 + 10));
		temperate = new JLabel();
		infoPanel.add(temperate);

		temperatureRange = new JLabel();
		infoPanel.add(temperatureRange);

		currentAtmosphericPressure = new JLabel();
		infoPanel.add(currentAtmosphericPressure);

		humidity = new JLabel();
		infoPanel.add(humidity);

		infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	private void createAndConfigureCityComboBox(
			final IWeatherInfoProviderFactory weatherInfoProviderFactory,
			Vector<String> cities) {
		// Create the combo box, and set 2nd item as Default
		comboCitiesList = new JComboBox<String>(cities);
		comboCitiesList.setSelectedIndex(DEFAULT_SELECTION);
		comboCitiesList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox<String> jcmbType = (JComboBox<String>) e.getSource();
				String city = (String) jcmbType.getSelectedItem();

				updateInfoForCity(weatherInfoProviderFactory, city);
			}

		});

		// Layout the demo
		setLayout(new BorderLayout());
		add(comboCitiesList, BorderLayout.NORTH);

	}

	/**
	 * Updates the panel by fetching the weather info from the provider
	 */
	private void updateInfoForCity(
			final IWeatherInfoProviderFactory weatherInfoProviderFactory,
			String city) {
		try {
			WeatherAppInfoModel model = new WeatherAppInfoModel(
					weatherInfoProviderFactory.getProvider(), new City(city));
			updateInfoPanel(model);
		} catch (WeatherAppException exp) {
			// In this case, Ideally we want to display on the page with
			// a proper error message
		}
	}

	private Vector<String> createCityNamesVector(
			ICityListProvider cityListProvider) {
		Vector<String> cities = new Vector<String>();
		for (City city : cityListProvider.getCities()) {
			cities.add(city.getName());
		}
		return cities;
	}

	/**
	 * Updates the UI InfoPanel with the new information
	 */
	private void updateInfoPanel(WeatherAppInfoModel model) {
		name.setText(model.getName());
		location.setText(model.getLocationInfo());
		currentWeatherConditions.setText(model.getCurrentWeatherConditions());
		weatherIcon.setIcon(model.getWeatherIcon());
		temperate.setText(model.getTemperate());
		temperatureRange.setText(model.getTemperatureRange());
		currentAtmosphericPressure.setText(model
				.getCurrentAtmosphericPressure());
		humidity.setText(model.getHumidity());
	}

}
