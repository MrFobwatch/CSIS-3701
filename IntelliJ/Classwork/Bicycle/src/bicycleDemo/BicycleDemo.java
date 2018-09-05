package bicycleDemo;
public class BicycleDemo {
	public static void main(String[] args) {
		//Create two bike object
		Bicycle bike1 = new Bicycle(0, 0, 5);
		Bicycle bike2 = new Bicycle(0, 0, 1);
		MountainBike bike3 = new MountainBike(4, 0, 0, 1);
		//Invoke methods on objects
		bike1.printStates();
		bike2.printStates();

		bike1.setCadence(50);
		bike1.speedUp(10);
		bike1.setGear(2);
		bike1.printStates();
		bike1.displayStatus("Hello");

		bike2.setCadence(50);
		bike2.speedUp(10);
		bike2.setGear(2);
		bike2.speedUp(10);
		bike2.setGear(3);
		bike2.setCadence(40);
		bike2.printStates();

		bike3.setCadence(40);
		bike3.speedUp(20);
		bike3.setHeight(10);
		bike3.setGear(3);
		bike3.printStates();





	}
}