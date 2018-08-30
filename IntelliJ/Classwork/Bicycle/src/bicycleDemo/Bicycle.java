package bicycleDemo;

public class Bicycle {
	int cadence = 0;
	int gear = 1;
	int speed = 0;

	void setCadence(int newCadence) {
		displayStatus("Changing Cadence from "+ cadence + " to " + newCadence);
		this.cadence = newCadence;
	}

	void setGear(int newGear) {
		displayStatus("Changing Gear from " + gear + " to " + newGear);
		this.gear = newGear;
	}

	void speedUp(int increment) {
		displayStatus("Changing Speed from " + speed + " to " +  (speed + increment));
		this.speed += increment;
	}

	void applyBrakes(int decrement){
		displayStatus("Changing speed from " + speed + " to " + (speed - decrement));
		this.speed -= decrement;
	}

	void printStates() {
		System.out.println("Cadence: " + cadence
		+ " Speed: " + speed
		+ " Gear: " + gear);
	}

	void displayStatus(String strMessage) {
		System.out.println(strMessage);
	}
}
