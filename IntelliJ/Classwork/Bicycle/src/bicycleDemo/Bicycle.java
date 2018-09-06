package bicycleDemo;

class Bicycle {
	private int cadence;
	private int gear;
	private int speed;

	public Bicycle(int cadence, int speed, int gear) {
		this.cadence = cadence;
		this.gear = gear;
		this.speed = speed;

	}

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
