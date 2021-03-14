package io.github.ilkou.avaj.exception;

public class AircraftTypeException extends Exception {
    public AircraftTypeException(String e) {
        super("Wrong aircraft type: " + e);
    }
}
