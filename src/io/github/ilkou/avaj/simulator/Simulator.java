package io.github.ilkou.avaj.simulator;

import io.github.ilkou.avaj.exception.AircraftHeightException;
import io.github.ilkou.avaj.exception.ScenarioFileException;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;

public class Simulator {
	private static int nbrOfSimulations;
	private static WeatherTower weatherTower;
	public static FileWriter file;

	static {
		try {
			file = new FileWriter("simulation.txt");
		} catch (IOException e) {
			e.printStackTrace();
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
				throw new ScenarioFileException("Each following line must contain five parameters separated by one space, with this format:\n"
						+ "TYPE NAME LONGITUDE LATITUDE HEIGHT.");
			Integer[] coord = { Integer.parseInt(parts[2]),
				Integer.parseInt(parts[3]),
				Integer.parseInt(parts[4]) };
			if (coord[2] < 0 || coord[2] > 100) {
				throw new AircraftHeightException();
			}
			AircraftFactory.newAircraft(parts[0], parts[1], coord[0], coord[1], coord[2])
				.registerTower(weatherTower);
			line = scenario.readLine();
		}
		scenario.close();
	}

	private static void run() throws IOException {
		file.write("");
		for (int i = 0; i < nbrOfSimulations; i++) {
			weatherTower.changeWeather();
		}
		file.close();
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("error: wrong number of arguments (given " + args.length + " expected 1)");
			System.out.println("usage: java -classpath src io.github.ilkou.avaj.simulator.Simulator scenario.txt");
			return;
		}
		try {
			weatherTower = new WeatherTower();
			parseScenario(args[0]);
			run();
		} catch (Exception whateverException) {
			System.err.println(whateverException);
		}
	}
}
