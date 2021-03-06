package guessgame;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * GuessApp implements the logic that is required to track the correct answer, the number of guesses
 * and other important values for the game
 */
public class GuessLogic {
    private Stack<Integer> guessesMade = new Stack<>();
    private int upperBound;
    private int lowerBound;
    private int correctNumber;
    private Random random = new java.util.Random();
    /*
    	public GuessLogic() {this(defaultLowerBound, defaultUpperBound);}

    	public GuessLogic(int upperBound) {	this(defaultLowerBound, upperBound);}
    */

    public GuessLogic(int lowerBound, int upperBound) {

        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        decideCorrectNumber();
//        guessesMade.setSize(upperBound);
        //		guessesMade = new int[upperBound];
    }

    private void decideCorrectNumber() {
        correctNumber =
                random.nextInt(upperBound)
                        + 1; // random.nextInt gets a number( 0<= number < bound) to also be able to
        // select our
        // bound number we add one to the output
    }

    public boolean isGuessCorrectNumber() {
        return (getCorrectNumber() == currentGuess());
    }

    public int getCorrectNumber() {
        return correctNumber;
    }

    private int currentGuess() {
        return guessesMade.peek();
    }

    public int guessNumberCount() {
        return (int) Arrays.stream(guessesMade.toArray()).count();
    }

    public void guessNumber(int guess) {
        guessesMade.push(guess);
        guessesMade.trimToSize();
    }

    public boolean isGuessValid(int guess) {
        // data validation performed here
        return guess >= lowerBound && guess <= upperBound;
    }

    public String toString() {
        return "GuessLogic{"
                       + "guessesMade="
                       + guessesMade
                       + ", upperBound="
                       + upperBound
                       + ", lowerBound="
                       + lowerBound
                       + ", correctNumber="
                       + correctNumber
                       + ", random="
                       + random
                       + '}';
    }
}
