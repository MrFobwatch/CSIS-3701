import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * The Calculator Class
 */
public class Calculator {

	private Scanner scan = new Scanner(System.in);
	private double total;
	private double totalMem;
	private double first;
	private double second;
	private String operator;

	public double getTotal() {
		return total;
	}

	public double getTotalMem() {
		return totalMem;
	}

	// Operations are private because they will be called by the perform calculation Function
	private void add(double number) {
		total = total + number;
	}

	private void subtract(double number) {
		total = total - number;

	}

	private void multiply(double number) {
		total = total * number;
	}

	private void divide(double number) {
		total = total / number;
	}

	public void addMem(double number) {
		totalMem = totalMem + number;
	}

	public void subtractMem(double number) {
		totalMem = totalMem - number;
	}

	public void clearMem() {
		totalMem = 0;
	}

	public void clearTotal() {
		total = 0;
	}

	private boolean doOperation(String operator, double number) {
		boolean calcSuccess = FALSE;
		switch (operator) {
			case "+":
				add(number);
				calcSuccess = TRUE;
				break;
			case "-":
				subtract(number);
				calcSuccess = TRUE;
				break;
			case "*":
				multiply(number);
				calcSuccess = TRUE;
				break;
			case "/":
				divide(number);
				calcSuccess = TRUE;
				break;
			default:
				System.out.println("Please use a simple mathematical symbol and try again");
				break;
		}
		return calcSuccess;

	}

	private void performCalculation() {
		//Get input
		getInputs();
		total = first;
		Boolean calcSuccess = doOperation(operator, second);
	}

	private void getInputs() {
		Boolean firstValue = FALSE;
		Boolean secondValue = FALSE; //Do we have a first and second number
		System.out.println("Enter a single operation Expression ");
		while (!scan.hasNext("[-+*/]")) {
			if (!firstValue && scan.hasNextDouble()) {
				first = scan.nextDouble();
				firstValue = TRUE;
				if (scan.hasNext("[-+*/]")) {
					operator = scan.next();
				}
			} else if (!secondValue && scan.hasNextDouble()) {
				second = scan.nextDouble();
				secondValue = TRUE;
			}

			if ((!firstValue && !secondValue) || operator == null) {
				System.out.println("Please Check your Input for numbers and correct symbols and try again");
				firstValue = FALSE;
				secondValue = FALSE;

				scan.nextLine();
			}
			if (firstValue && secondValue) break;
		}


	}

	public void run() {
		performCalculation();
		System.out.println("You entered " + first + " " + operator + " " + second);
		System.out.println("That equals " + getTotal());
	}

}



