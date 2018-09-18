package automobile;

public class Automobiles {
	public static void main(String[] args) {
		Automobile a1 = new Automobile("Ford", "Blue");
//		a1.color = "Blue";
//		a1. make = "Ford";
		a1.license = "AZ62MN";

		a1.showStatus();

		a1.changeColor("Green");

		a1.startEngine();

		a1.showStatus();
	}
}
