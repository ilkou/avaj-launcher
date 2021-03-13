package io.github.ilkou.avaj.simulator;

import java.io.IOException;
import java.util.HashMap;

class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	private static final HashMap<String, String> funnyMessages;

	static {
		funnyMessages = new HashMap<String, String>();
		funnyMessages.put("RAIN", "It's raining de-de-de-de");
		funnyMessages.put("FOG", "I can't see sh*t");
		funnyMessages.put("SUN", "Nice day for fishing ain't it ~Rowan");
		funnyMessages.put("SNOW", "Be like snow: beautiful but so f*cking cold");
	}

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() throws IOException {
		String weather = weatherTower.getWeather(this.coordinates);
		if (weather.equals("RAIN"))
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 5);
		else if (weather.equals("FOG"))
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 3);
		else if (weather.equals("SUN"))
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() + 4);
		else if (weather.equals("SNOW"))
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 15);
		Simulator.file.write("Baloon#" + this.name + "(" + this.id + "): " + funnyMessages.get(weather) + ".\n");
		if (this.coordinates.getHeight() == 0) {
			Simulator.file.write("Baloon#" + this.name + "(" + this.id + ") landing.\n");
			this.weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower) throws IOException {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}
