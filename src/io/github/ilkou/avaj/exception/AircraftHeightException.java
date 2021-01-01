package io.github.ilkou.avaj.exception;

public class AircraftHeightException extends Exception {
    public AircraftHeightException() {
        super("The height must be in the 0-100 range");
    }
}
