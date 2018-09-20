package dicegame;

import java.security.SecureRandom;

public class DiceGame {


	public static void main(String[] args) {

		System.out.println("Welcome to the DICE game");
		Dice d1 = new Dice();
		for (int i = 1; i < 10; i++) {
			int dice1 = d1.rollDice(20);
			System.out.println("You rolled: " + dice1);
		}


	}

//	public static int rollDice(int numSides) {
//		int diceValue = randomNumber.nextInt(numSides) + 1; //Random decider of value
//		return diceValue;
//	}
}

