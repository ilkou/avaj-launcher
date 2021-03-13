package io.github.ilkou.avaj.simulator;

import java.io.IOException;
import java.util.HashMap;

class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	private static final HashMap<String, String> funnyMessages;

	static {
		funnyMessages = new HashMap<String, String>();
		funnyMessages.put("RAIN", "Let's just distribute some water");
		funnyMessages.put("FOG", "My rotor blades are not only for flying !");
		funnyMessages.put("SUN", "It's HOTTER than the Screaming Sun Planet");
		funnyMessages.put("SNOW", "Feels like another christmas far away from home :(");
	}

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() throws IOException {
		String weather = weatherTower.getWeather(this.coordinates);
		if (weather.equals("RAIN"))
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight());
		else if (weather.equals("FOG"))
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight());
		else if (weather.equals("SUN"))
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 2);
		else if (weather.equals("SNOW")) //just delete me already
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 12);
		Simulator.file.write("Helicopter#" + this.name + "(" + this.id + "): " + funnyMessages.get(weather) + ".\n");
		if (this.coordinates.getHeight() == 0) {
			Simulator.file.write("Helicopter#" + this.name + "(" + this.id + ") landing.\n");
			this.weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower) throws IOException {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}
