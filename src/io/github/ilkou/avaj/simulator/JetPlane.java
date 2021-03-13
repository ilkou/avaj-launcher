package io.github.ilkou.avaj.simulator;

import java.io.IOException;
import java.util.HashMap;

class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	private static final HashMap<String, String> funnyMessages;

	static {
		funnyMessages = new HashMap<String, String>();
		funnyMessages.put("RAIN", "It's RAINING SIDEWAYS ~Ollie");
		funnyMessages.put("FOG", "There's CLOUDS, down here");
		funnyMessages.put("SUN", "It's HOT ~Ollie");
		funnyMessages.put("SNOW", "It's COLD ~Ollie");
	}

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() throws IOException {
		String weather = weatherTower.getWeather(this.coordinates);
		if (weather.equals("RAIN"))
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 5,
					this.coordinates.getHeight());
		else if (weather.equals("FOG"))
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 1,
					this.coordinates.getHeight());
		else if (weather.equals("SUN"))
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 10,
					this.coordinates.getHeight() + 2);
		else
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 7);
		Simulator.file.write("JetPlane#" + this.name + "(" + this.id + "): " + funnyMessages.get(weather) + ".\n");
		if (this.coordinates.getHeight() <= 0) {
			Simulator.file.write("JetPlane#" + this.name + "(" + this.id + ") landing.\n");
			this.weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower) throws IOException {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}
