package io.github.ilkou.avaj.simulator;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;

class Simulator {
	private static int nbrOfSimulations;
	private static WeatherTower weatherTower;
	static class ScenarioFileException extends Exception {
		public ScenarioFileException(String e) {
			super(e);
		}
		public ScenarioFileException() {
			super();
		}
	}
	private static void parseScenario(String scenarioFileName) throws Exception {
		BufferedReader scenario = new BufferedReader(new FileReader(scenarioFileName));
		String line = scenario.readLine();
		if (line != null) {
			nbrOfSimulations = Integer.parseInt(line);
			if (nbrOfSimulations < 0)
				throw new ScenarioFileException("The first line must contain a positive integer number");
		}
		else
			throw new ScenarioFileException("Empty File !");
		line = scenario.readLine();
		while (line != null) {
			String []parts = line.split(" ");
			if (parts.length != 5)
				throw new ScenarioFileException("Each following ling must contain five parameters");
			Integer coord[] = { Integer.parseInt(parts[2]),
				Integer.parseInt(parts[3]),
				Integer.parseInt(parts[4]) };
			AircraftFactory.newAircraft(parts[0], parts[1], coord[0], coord[1], coord[2])
				.registerTower(weatherTower);
			line = scenario.readLine();
		}
		scenario.close();
	}

	private static void run() throws Exception {
		FileWriter simulationFile = new FileWriter("simulation.txt");
		simulationFile.write("");
		// traitement
		for (int i = 0; i < nbrOfSimulations; i++) {
			weatherTower.changeWeather();
		}
		simulationFile.close();
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("error: wrong number of arguments (given " + args.length + " expected 1)");
			System.out.println("usage: java io.github.ilkou.simulator.Simulator scenario.txt");
			return;
		}
		try {
			weatherTower = new WeatherTower();
			parseScenario(args[0]);
			run();
		} catch (IOException e) {
			System.err.println(e);
		} catch (NumberFormatException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
