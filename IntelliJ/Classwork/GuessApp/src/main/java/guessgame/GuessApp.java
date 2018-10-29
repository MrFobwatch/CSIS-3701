package guessgame;

public class GuessApp {
	private static final int defaultUpperBound = 10;
	private static final int defaultLowerBound = 1;
	public int lowerBound = defaultLowerBound;
	public int upperBound = defaultUpperBound;
	private GuessLogic game;

	public GuessApp() {
		GuessLogic game = new GuessLogic(defaultLowerBound, defaultUpperBound);
	}

	public GuessApp(int upperBound) {
		GuessLogic game = new GuessLogic(defaultLowerBound, upperBound);
		this.upperBound = upperBound;
	}

	public GuessApp(int lowerBound, int upperBound) {
		GuessLogic game = new GuessLogic(lowerBound, upperBound);
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public void gamePlay() {
		turn();
		while (!checkCorrect())
		{
			turn();
		}
	}

	private void turn() {
		printPrompt();
		game.guessNumber(getUserGuess());
	}

	private void printPrompt() {
		System.out.print("Enter a guess between " + lowerBound + " and " + upperBound + ": " );
	}

	private int getUserGuess() {
		int num = -1;

		return num;
	}
}
