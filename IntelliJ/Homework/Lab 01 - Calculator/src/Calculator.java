import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * The Calculator Class
 */
public class Calculator {

	private double total;
	private double totalMem;
	Scanner scan = new Scanner(System.in);

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

	public boolean doOperation(char operator, double number) {
		boolean calcSuccess = FALSE;
		if (operator == '+') {
			add(number);
			calcSuccess = TRUE;
		} else if (operator == '-') {
			subtract(number);
			calcSuccess = TRUE;
		} else if (operator == '*') {
			multiply(number);
			calcSuccess = TRUE;
		} else if (operator == '/') {
			divide(number);
			calcSuccess = TRUE;
		} else
			System.out.println("Please use a simple mathematical symbol and try again");
		return calcSuccess;

	}

	public void performCalculation() {
		char inputOperator;
		double inputNumber;
		//Get input Methods
//		getInputs();
		Boolean calcSucess = doOperation(inputOperator, inputNumber);
		while (calcSucess == FALSE) {
			//get new operator
			char newOperator = getInputOperator();
			inputOperator = newOperator;
			doOperation(newOperator, inputNumber);
		}


	}

	private char getInputOperator() {
		return String.valueOf(scan.nextLine());

	}

	private double getInputNumber() {
		return Double.parseDouble(scan.nextLine());
	}


	//Input Function with data validation
	//Printed Interface

}



