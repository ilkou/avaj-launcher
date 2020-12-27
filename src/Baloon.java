import java.util.HashMap;

class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	private HashMap<String, String> funnyMessages;


	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
		funnyMessages = new HashMap<String, String>();
		funnyMessages.put("RAIN", "It's raining de-de-de-de");
		funnyMessages.put("FOG", "I can't see sh*t");
		funnyMessages.put("SUN", "Nice day for fishing ain't it ~Rowan");
		funnyMessages.put("SNOW", "Be like snow: beautiful but so f*cking cold");
	}
	public void updateConditions() {
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
		else if (weather.equals("SNOW")) //just delete me already
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 15);
		System.out.println("Baloon#" + this.name + "(" + this.id + "): " + funnyMessages.get(weather) + ".");
	}
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}
