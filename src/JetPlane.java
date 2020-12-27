import java.util.HashMap;

class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	private HashMap<String, String> funnyMessages;

	JetPlane(String name, Coordinates coordinates) {
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
		else if (weather.equals("SNOW")) //just delete me already
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 7);
		System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + funnyMessages.get(weather) + ".");
	}
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}
