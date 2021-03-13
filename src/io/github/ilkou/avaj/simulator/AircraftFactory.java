package io.github.ilkou.avaj.simulator;

import io.github.ilkou.avaj.exception.AircraftTypeException;
import io.github.ilkou.avaj.md5.Md5Decrypt;

class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws AircraftTypeException {
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		if (type.equals("Helicopter") || Md5Decrypt.decryptAircraftType(type).equals("Helicopter"))
			return (new Helicopter(name, coordinates));
		else if (type.equals("JetPlane") || Md5Decrypt.decryptAircraftType(type).equals("JetPlane"))
			return (new JetPlane(name, coordinates));
		else if (type.equals("Baloon") || Md5Decrypt.decryptAircraftType(type).equals("Baloon"))
			return (new Baloon(name, coordinates));
		else
			throw new AircraftTypeException(type);
	}
}
