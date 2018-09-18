package elevator;

import java.util.Scanner;

public class Elevator {

	static int floor;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int target_floor;

		floor = (int) (Math.random() * 10 + 1);

		System.out.println("The elevator is now on floor " + floor);
		System.out.println("Which floor are you at now (0-10) where 0 = basement: ");
		int current_floor = Integer.parseInt(scan.nextLine());

		if (floor == current_floor) {
			System.out.println("Enter the elevator");
		} else {
			MoveElevator(current_floor);
		}
		System.out.println("To which floor would you like to go (0-10) where 0 = basement");
		target_floor = Integer.parseInt(scan.nextLine());

	}

	public static void MoveElevator(int target_floor) {
		int direction;

		System.out.println("Doors closing...The elevator is on the move.");

		if (target_floor > floor){
			System.out.println("The elevator is on its way up...");
			direction =1;
		}
		else
		{
			System.out.println("The elevator is on its way down...");
			direction = -1;
		}

		while (target_floor != floor){
			floor+=direction;
			System.out.println("The elevator is now at on floor " + floor);
		}


	}

}
