package guessgame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessApp {
    private static final int defaultUpperBound = 10;
    private static final int defaultLowerBound = 1;
    public int lowerBound = defaultLowerBound;
    public int upperBound = defaultUpperBound;
    private GuessLogic game;
    //    private GuessLogic game = new GuessLogic(defaultLowerBound, defaultUpperBound);
    private Scanner scan = new Scanner(System.in);

    public GuessApp() {
        game = new GuessLogic(defaultLowerBound, defaultUpperBound);
    }

    public GuessApp(int upperBound) {
        game = new GuessLogic(defaultLowerBound, upperBound);
        this.upperBound = upperBound;
    }

    public GuessApp(int lowerBound, int upperBound) {
        game = new GuessLogic(lowerBound, upperBound);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public void gamePlay() {
        while (game.guessNumberCount() == 0 || !checkCorrect()) {
            printPrompt();
            turn();
            System.out.println("That is not correct.");
        }

        printNumberOfGuesses();
        System.out.println(game.toString());
    }

    private boolean checkCorrect() {
        return game.isGuessCorrectNumber();
    }

    private void printPrompt() {
        System.out.print("Enter a guess between " + lowerBound + " and " + upperBound + ": ");
    }

    private void turn() {
        int currentGuess = getUserGuess();
        while (!game.isGuessValid(currentGuess)) {
            System.out.println(
                    "You must enter a number between " + lowerBound + " and " + upperBound + "!");
            currentGuess = getUserGuess();
        }
        if (game.isGuessValid(currentGuess)) {
            game.guessNumber(currentGuess);
        }
    }

    private void printNumberOfGuesses() {
        System.out.println("You guessed it in " + game.guessNumberCount() + " guesses!");
    }

    private int getUserGuess() {
        boolean guessIsInteger;
        int input = 0;
        do {
            try {
                input = scan.nextInt();
                guessIsInteger = true;
            } catch (InputMismatchException excpt) {
                System.out.println("Not an integer, Try again.");
                scan.nextLine();
                guessIsInteger = false;
            }
        } while (!guessIsInteger);
        return input;
    }
}
