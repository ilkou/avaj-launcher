package io.github.ilkou.avaj.simulator;

import java.io.IOException;

interface Flyable {
	public void updateConditions() throws IOException;
	public void registerTower(WeatherTower weatherTower) throws IOException;
}
