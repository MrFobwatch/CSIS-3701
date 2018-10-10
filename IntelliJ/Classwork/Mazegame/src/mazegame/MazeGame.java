package mazegame;

import java.util.Scanner;

public class MazeGame {
	public static void main(String[] args) {
		Maze myMaze = new Maze();
		Scanner input = new Scanner(System.in);

		char move = ' ';
		do {
			myMaze.displayBoard();
			System.out.println("Please enter your move or Q to quit");
//			if(input.hasNext(([UDRLQ])){
				move = input.next().charAt(0);
//			}
			if(move == 'I'){
				myMaze.inquire();
			}
			else {
				myMaze.move(move);
			}
		} while (move != 'Q');
	}
}
