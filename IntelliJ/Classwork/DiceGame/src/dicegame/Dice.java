package dicegame;

import java.security.SecureRandom;

public class Dice {
	private static final SecureRandom randomNumber = new SecureRandom();

	public static int rollDice(int numSides) {
		int diceValue = randomNumber.nextInt(numSides) + 1; //Random decider of value
		return diceValue;
	}
}
