import java.security.SecureRandom;

public class DiceGame {

	public static void main(String[] args) {
		// write your code here
		System.out.println("Welcome to the DICE game");
		SecureRandom randomNumber = new SecureRandom();
		int face;
		for (int i = 1; i < 10; i++) {
			face = randomNumber.nextInt(6) + 1; //Random decider of value
			System.out.println("Rolled: " + face);
		}
	}

}

