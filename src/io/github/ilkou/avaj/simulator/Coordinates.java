package io.github.ilkou.avaj.simulator;

class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) {
		longitude = longitude < 0 ? 0 : longitude;
		latitude = latitude < 0 ? 0 : latitude;
		height = height < 0 ? 0 : (height > 100 ? 100 : height);
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude() {
		return (this.longitude);
	}

	public int getLatitude() {
		return (this.latitude);
	}

	public int getHeight() {
		return (this.height);
	}
}
