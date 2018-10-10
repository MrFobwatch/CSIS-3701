package mazegame;


import java.security.SecureRandom;

public class Maze {
	static public final int NUM_ROWs = 8;
	static public final int NUM_COLS = 8;
	protected int[][] Board = new int[NUM_ROWs][NUM_COLS];
	private int col_pos;
	private int row_pos;

	public Maze() {
		col_pos = 0;
		row_pos = 0;
		//whereAmI();
		loadBoard();
		displayBoard();
	}

	public void whereAmI() {
		System.out.println("You are at row: " + row_pos + " and column: " + col_pos);
	}

	public void move(char Direction) {
		switch (Direction) {
			case 'U':
				if (row_pos > 0) {
					row_pos -= 1;
				} else {
					System.out.println("Invalid move");
				}
				break;
			case 'D':
				if (row_pos < NUM_ROWs) {
					row_pos += 1;
				} else {
					System.out.println("Invalid move");
				}
				break;
			case 'L':
				if (col_pos > 0) {
					col_pos -= 1;
				} else {
					System.out.println("Invalid move");
				}
				break;
			case 'R':
				if (col_pos < NUM_COLS) {
					col_pos += 1;
				} else {
					System.out.println("Invalid move");
				}
				break;
		}
//		whereAmI();
		inquire();
		displayBoard();
	}

	public void displayBoard() {
		for (int row = 0; row < NUM_ROWs; row++) {
			System.out.println("---------------------------------");
//			System.out.println("_________________________________");
			for (int col = 0; col < NUM_COLS; col++) {
				if (Board[row_pos][col_pos] != 0) {
					System.out.print("|*");
				} else {
					System.out.print("| ");
				}

				if (row == row_pos && col == col_pos) {
					System.out.print("X ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println("|");


		}
		System.out.println("_________________________________");

		System.out.println();


	}

	public void inquire() {
		if (Board[row_pos][col_pos] > 0) {
			System.out.println("There are " + Board[row_pos][col_pos] + " or more objects in this room.\n");
		} else {
			System.out.println("There is nothing in this room.\n");
		}
	}

	public void loadBoard() {
		SecureRandom randomNumbers = new SecureRandom();
		for (int cell = 0; cell < 10; cell++) {
			int items = 1 + randomNumbers.nextInt(5);
			int row, col;
			do {
				row = randomNumbers.nextInt(8);
				col = randomNumbers.nextInt(8);
			} while (Board[row][col] != 0);
			System.out.println("Placing " + items + " in room (" + row + "," + col + ")");
			Board[row][col] = items;


		}

	}
}

