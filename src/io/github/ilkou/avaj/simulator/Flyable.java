package io.github.ilkou.avaj.simulator;

import java.io.IOException;

interface Flyable {
	void updateConditions() throws IOException;
	void registerTower(WeatherTower weatherTower) throws IOException;
}
