package automobile;

import java.time.Duration;
import java.time.Instant;

public class Automobile {

	String make;
	String color;
	String license = "not assigned";
	boolean engineState = false;
	Instant start;
	Instant timeNow;
	long timeRunning = 0;

	public Automobile(String m, String c) {
		make = m;
		color = c;
	}

	void startEngine() {
		if (engineState == true) {
			System.out.println("The engine is already on.");

		} else {
			engineState = true;
			start = Instant.now();
			System.out.println("The engine is now on.");
		}
	}

	void setLicense(String license) {
		this.license = license;
	}

	void showStatus() {
		System.out.println("This automobile is a " + color + " " + make + " ");
		System.out.println("The license plate for this car is " + license);
		if (engineState == true) {
			System.out.println("The engine is on.");
			timeNow = Instant.now();
			Duration timeElapsed = Duration.between(start, timeNow);
			System.out.println("The automobile has been on for: " + timeElapsed.toMillis() + " milliseconds");
		} else {
			System.out.println("The engine is not on.");

		}
	}

	public void changeColor(String color) {
		this.color = color;
	}
}
