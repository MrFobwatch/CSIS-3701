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
	}

	private void turn() {
	}

	private void printPrompt() {
		System.out.print("Enter a guess between ");
		System.out.print(lowerBound);
		System.out.print(" and ");
		System.out.print(upperBound + ": " )
	}

	private int getUserGuess() {
		int num = -1;

		return num;
	}
}
