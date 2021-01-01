package io.github.ilkou.avaj.simulator;

import java.io.IOException;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}
	void changeWeather() throws IOException {
		this.conditionsChanged();
	}
}
